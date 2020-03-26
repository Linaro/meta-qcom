DEPENDS += "skales-native"

# param ${1} kernel image
# param ${2} kernel cmdline
# param ${3} output boot image file name
priv_make_image() {
    ${STAGING_BINDIR_NATIVE}/skales/mkbootimg --kernel ${B}/arch/${ARCH}/boot/${1} \
              --ramdisk ${B}/initrd.img \
              --output ${DEPLOYDIR}/${3}.img \
              --pagesize ${QCOM_BOOTIMG_PAGE_SIZE} \
              --base ${QCOM_BOOTIMG_KERNEL_BASE} \
              --cmdline "${2}"
}

do_deploy_append() {
    tmp="${SERIAL_CONSOLES}"
    baudrate=`echo $tmp | sed 's/\;.*//'`
    ttydev=`echo $tmp | sed -e 's/^[0-9]*\;//' -e 's/\s.*//' -e 's/\;.*//'`

    # mkbootimg requires an initrd file, make fake one that will be ignored
    # during boot
    echo "This is not an initrd" > ${B}/initrd.img

    set -x

    for dt in ${KERNEL_DEVICETREE}; do
        KERNEL_IMAGE="${KERNEL_IMAGETYPE}"
        BOOT_IMAGE_BASE_NAME="boot-${KERNEL_IMAGE_NAME}"
        BOOT_IMAGE_SYMLINK_NAME="boot-${KERNEL_IMAGE_LINK_NAME}"
        SD_BOOT_IMAGE_BASE_NAME="boot-sd${KERNEL_IMAGE_NAME}" 
        SD_BOOT_IMAGE_SYMLINK_NAME="boot-sd-${KERNEL_IMAGE_LINK_NAME}"

	# The qcom-armv8a is a MACHINE that support build multiple Android boot images so certain parameters like rootfs device,
	# kernel base and page size needs to be set by dtb instead of every machine configuration.
        if [ "${MACHINE}" = "qcom-armv8a" ]; then
            dt_basename=$(basename $dt)

            QCOM_BOOTIMG_ROOTFS="sda1"
            SD_QCOM_BOOTIMG_ROOTFS="undefined"
            QCOM_BOOTIMG_PAGE_SIZE="4096"

            case $dt_basename in
              apq8016-sbc.dtb)
                BOARDNAME="dragonboard-410c"
                QCOM_BOOTIMG_PAGE_SIZE="2048"
                QCOM_BOOTIMG_ROOTFS="mmcblk0p14"
                SD_QCOM_BOOTIMG_ROOTFS="mmcblk1p7"
                ;;
              apq8096-db820c.dtb)
                BOARDNAME="dragonboard-820c"
                ;;
              sdm845-db845c.dtb)
                BOARDNAME="dragonboard-845c"
                KERNEL_CMDLINE_APPEND=" clk_ignore_unused pd_ignore_unused"
                ;;
              qrb5165-rb5.dtb)
                BOARDNAME="qrb5165-rb5"
                QCOM_BOOTIMG_ROOTFS="sda8"
                ;;
              *)
                bbfatal "Device tree ${dt_basename} boot image requested but no support for it."
                ;;
            esac

            KERNEL_IMAGE="${KERNEL_IMAGE}+$dt_basename"
            BOOT_IMAGE_BASE_NAME="${BOOT_IMAGE_BASE_NAME}-${BOARDNAME}"
            BOOT_IMAGE_SYMLINK_NAME="${BOOT_IMAGE_SYMLINK_NAME}-${BOARDNAME}"
            SD_BOOT_IMAGE_BASE_NAME="${SD_BOOT_IMAGE_BASE_NAME}-${BOARDNAME}" 
            SD_BOOT_IMAGE_SYMLINK_NAME="${SD_BOOT_IMAGE_SYMLINK_NAME}-${BOARDNAME}"
        else
            # don't build bootimg if rootfs partition is not defined
            if [ "${QCOM_BOOTIMG_ROOTFS}" == "undefined"]; then
                bbfatal "Rootfs partition must be defined"
            fi

            if [ "${MACHINE}" = "dragonboard-845c" ]; then
                KERNEL_CMDLINE_APPEND=" clk_ignore_unused pd_ignore_unused"
            fi
        fi

        KERNEL_CMDLINE="root=/dev/${QCOM_BOOTIMG_ROOTFS} rw rootwait console=${ttydev},${baudrate}n8 ${KERNEL_CMDLINE_APPEND}"
        priv_make_image "${KERNEL_IMAGE}" "${KERNEL_CMDLINE}" "${BOOT_IMAGE_BASE_NAME}"
        ln -sf ${BOOT_IMAGE_BASE_NAME}.img ${DEPLOYDIR}/${BOOT_IMAGE_SYMLINK_NAME}.img

        # build sd boot image only for machines supporting it.
        if [ "${SD_QCOM_BOOTIMG_ROOTFS}" != "undefined" ]; then
            KERNEL_CMDLINE="root=/dev/${SD_QCOM_BOOTIMG_ROOTFS} rw rootwait console=${ttydev},${baudrate}n8 ${KERNEL_CMDLINE_APPEND}"
            priv_make_image "${KERNEL_IMAGE}" "${KERNEL_CMDLINE}" "${SD_BOOT_IMAGE_BASE_NAME}"
            ln -sf ${SD_BOOT_IMAGE_BASE_NAME}.img ${DEPLOYDIR}/${SD_BOOT_IMAGE_SYMLINK_NAME}.img
        fi
    done
}
