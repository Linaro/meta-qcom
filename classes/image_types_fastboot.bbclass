inherit image_types

IMAGE_TYPES += "fastboot"
IMAGE_TYPEDEP_fastboot = "ext4"
IMAGE_DEPENDS_fastboot = "gptfdisk-native bootloader-emmc-linux virtual/bootloader zip-native"

# Default to 8 GB (not GiB) eMMC size
FASTBOOT_EMMC_SIZE ?= "7812500"
FASTBOOT_ABOOT ?= "${DEPLOY_DIR_IMAGE}/emmc_appsboot.mbn"
FASTBOOT_KERNEL ?= "${DEPLOY_DIR_IMAGE}/boot-${MACHINE}.img"
FASTBOOT_ROOTFS ?= "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ext4"
FASTBOOT_PARTTABLE ?= "${STAGING_LIBDIR}/bootloader-emmc-linux/partitions.txt"

create_fastboot_pkg() {
    rm -f ${WORKDIR}/partitions.tmp
    grep -v '^[[:space:]]*#' ${FASTBOOT_PARTTABLE} > ${WORKDIR}/partitions.tmp
    SIZE=0
    while IFS=, read name size type file startpos; do
        if [ -z "$name" -o -z "$size" ]; then continue; fi
        if [ $startpos -ne 0 ]; then
            SIZE=`expr $startpos + $size`
        else
            SIZE=`expr $SIZE + $size`
        fi
    done < ${WORKDIR}/partitions.tmp
    if [ $SIZE -lt ${FASTBOOT_EMMC_SIZE} ]; then
         SIZE=${FASTBOOT_EMMC_SIZE}
    elif [ $SIZE -gt ${FASTBOOT_EMMC_SIZE} ]; then
         bbfatal "Calculated partition size total $SIZE exceeds FASTBOOT_EMMC_SIZE ${FASTBOOT_EMMC_SIZE}"
         exit 1
    fi
    rm -f ${WORKDIR}/emmc.img
    dd if=/dev/zero of=${WORKDIR}/emmc.img bs=1 seek=$(expr 1024 \* $SIZE - 1) conv=notrunc count=1

    rm -rf ${WORKDIR}/fastboot
    mkdir ${WORKDIR}/fastboot
    echo "#!/bin/sh" > ${WORKDIR}/fastboot/flashall
    echo "fastboot flash partition parttable.bin" >> ${WORKDIR}/fastboot/flashall
    chmod +x ${WORKDIR}/fastboot/flashall
    partnum=0
    while IFS=, read name size type file startpos; do
        if [ -z "$name" -o -z "$size" ]; then continue; fi
        case "$file" in
            ABOOT) file="${FASTBOOT_ABOOT}" ;;
            KERNEL) file="${FASTBOOT_KERNEL}" ;;
            ROOTFS) file="${FASTBOOT_ROOTFS}" ;;
            *) test -z "$file" || file="${STAGING_LIBDIR}/bootloader-emmc-linux/$file" ;;
        esac
        partnum=$(expr $partnum + 1)
        if [ -n "$type" ]; then
            typearg="--typecode=$partnum:$type"
        else
            typearg=""
        fi
        sgdisk -a 1 --new=$partnum:$(expr $startpos \* 2):+$(expr $size \* 2) -c $partnum:$name $typearg ${WORKDIR}/emmc.img
        if [ -n "$file" ]; then
            echo "fastboot flash $name $(basename $file)" >> ${WORKDIR}/fastboot/flashall
            cp "$file" ${WORKDIR}/fastboot/
        else
            echo "fastboot erase $name" >> ${WORKDIR}/fastboot/flashall
        fi
    done < ${WORKDIR}/partitions.tmp

    sgdisk -p ${WORKDIR}/emmc.img

    rm -f ${WORKDIR}/mbr ${WORKDIR}/gpt-primary ${WORKDIR}/gpt-secondary ${WORKDIR}/gpt-data ${WORKDIR}/emmc.backup
    sgdisk -b ${WORKDIR}/emmc.backup ${WORKDIR}/emmc.img
    dd if=${WORKDIR}/emmc.backup of=${WORKDIR}/mbr bs=512 count=1
    dd if=${WORKDIR}/emmc.backup of=${WORKDIR}/gpt-primary bs=512 count=1 skip=1
    dd if=${WORKDIR}/emmc.backup of=${WORKDIR}/gpt-secondary bs=512 count=1 skip=2
    dd if=${WORKDIR}/emmc.backup of=${WORKDIR}/gpt-data bs=512 count=32 skip=3 conv=notrunc
    cat ${WORKDIR}/mbr ${WORKDIR}/gpt-primary ${WORKDIR}/gpt-data ${WORKDIR}/gpt-data ${WORKDIR}/gpt-secondary > ${WORKDIR}/fastboot/parttable.bin
    cd ${WORKDIR}/fastboot
    zip ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.zip *
    ln -sf ${IMAGE_NAME}.zip ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.zip

    rm -f ${WORKDIR}/emmc.img
}

IMAGE_CMD_fastboot = "create_fastboot_pkg"
