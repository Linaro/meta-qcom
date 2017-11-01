inherit image_types

QCOM_BOOTIMG_ROOTFS ?= "undefined"
QCOM_BOOTIMG_CMDLINE ?= "root=/dev/${QCOM_BOOTIMG_ROOTFS} rw rootwait"
QCOM_BOOTIMG_KERNEL ?= "${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}"
QCOM_BOOTIMG_DTIMG ?= "${DEPLOY_DIR_IMAGE}/dt-${MACHINE}.img"

# sizes in KiB
QCOM_BOOTIMG_MAX_KERNSIZE ?= "32768"
QCOM_BOOTIMG_MAX_RDSIZE ?= "32768"

oe_qbootimg() {
    local ksize=`stat -L -c "%s" ${QCOM_BOOTIMG_KERNEL}`
    local rdsize=`stat -L -c "%s" $1`
    if [ $ksize -gt ${@int(d.getVar('QCOM_BOOTIMG_MAX_KERNSIZE')) * 1024} ]; then
        bbfatal "kernel (size $ksize) must be less than ${QCOM_BOOTIMG_MAX_KERNSIZE} KiB"
    fi
    if [ $rdsize -gt ${@int(d.getVar('QCOM_BOOTIMG_MAX_RDSIZE')) * 1024} ]; then
        bbfatal "initrd (size $rdsize) must be less than ${QCOM_BOOTIMG_MAX_RDSIZE} KiB"
    fi
    mkbootimg_dtarg=""
    if [ "${QCOM_BOOTIMG_BUNDLE_DT}" = "1" ]; then
        mkbootimg_dtarg="--dt ${QCOM_BOOTIMG_DTIMG}"
    fi
    tmp="${SERIAL_CONSOLES}"
    baudrate=`echo $tmp | sed 's/\;.*//'`
    ttydev=`echo $tmp | sed -e 's/^[0-9]*\;//' -e 's/\s.*//' -e 's/\;.*//'`
    ${STAGING_BINDIR_NATIVE}/skales/mkbootimg --kernel ${QCOM_BOOTIMG_KERNEL} \
        $mkbootimg_dtarg \
        --ramdisk $1 \
	--pagesize ${QCOM_BOOTIMG_PAGE_SIZE} \
	--base ${QCOM_BOOTIMG_KERNEL_BASE} \
	--cmdline "console=${ttydev},${baudrate}n8 ${QCOM_BOOTIMG_CMDLINE}" \
	--output ${IMGDEPLOYDIR}/$1.qboot
}

make_qboot_image() {
    local type="$1"
    oe_qbootimg ${IMAGE_NAME}.rootfs.${type}
}
make_qboot_image[vardepsexclude] += "DATETIME BUILDNAME"

CONVERSIONTYPES += "gz.qboot qboot"
CONVERSION_DEPENDS_qboot = "skales-native virtual/kernel:do_deploy"
CONVERSION_CMD_qboot = "make_qboot_image ${type}"
CONVERSION_CMD_gz.qboot = "${CONVERSION_CMD_gz}; make_qboot_image ${type}.gz"

IMAGE_TYPES += "cpio.gz.qboot"
