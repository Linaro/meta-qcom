inherit image_types

QCOM_BOOTIMG_ROOTFS ?= "undefined"
QCOM_BOOTIMG_CMDLINE ?= "root=/dev/${QCOM_BOOTIMG_ROOTFS} rw rootwait"
QCOM_BOOTIMG_KERNEL ?= "${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}"
QCOM_BOOTIMG_DTIMG ?= "${DEPLOY_DIR_IMAGE}/dt-${MACHINE}.img"

oe_qbootimg() {
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
CONVERSION_DEPENDS_qboot = "skales-native"
CONVERSION_CMD_qboot = "make_qboot_image ${type}"
CONVERSION_CMD_gz.qboot = "${CONVERSION_CMD_gz}; make_qboot_image ${type}.gz"

IMAGE_TYPES += "cpio.gz.qboot"
