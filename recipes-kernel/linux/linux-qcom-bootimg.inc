DEPENDS += "skales-native"

QCOM_BOOTIMG_ROOTFS ?= "undefined"

# set output file names
DT_IMAGE_BASE_NAME = "dt-${KERNEL_IMAGE_BASE_NAME}"
DT_IMAGE_SYMLINK_NAME = "dt-${KERNEL_IMAGE_SYMLINK_NAME}"
BOOT_IMAGE_BASE_NAME = "boot-${KERNEL_IMAGE_BASE_NAME}"
BOOT_IMAGE_SYMLINK_NAME = "boot-${KERNEL_IMAGE_SYMLINK_NAME}"

do_deploy_append() {

    mkbootimg_dtarg=""
    if [ "${QCOM_BOOTIMG_BUNDLE_DT}" = "1" ]; then
        export LD_LIBRARY_PATH="$LD_LIBRARY_PATH:${STAGING_LIBDIR_NATIVE}"
        ${STAGING_BINDIR_NATIVE}/skales/dtbTool -o ${DEPLOYDIR}/${DT_IMAGE_BASE_NAME}.img -s ${QCOM_BOOTIMG_PAGE_SIZE} ${B}/arch/${ARCH}/boot/dts/qcom/
        mkbootimg_dtarg="--dt ${DEPLOYDIR}/${DT_IMAGE_BASE_NAME}.img"
        ln -sf ${DT_IMAGE_BASE_NAME}.img ${DEPLOYDIR}/${DT_IMAGE_SYMLINK_NAME}.img
    fi

    tmp="${SERIAL_CONSOLES}"
    baudrate=`echo $tmp | sed 's/\;.*//'`
    ttydev=`echo $tmp | sed -e 's/^[0-9]*\;//' -e 's/\s.*//' -e 's/\;.*//'`

    # mkbootimg requires an initrd file, make fake one that will be ignored
    # during boot
    echo "This is not an initrd" > ${B}/initrd.img

    ${STAGING_BINDIR_NATIVE}/skales/mkbootimg --kernel ${B}/arch/${ARCH}/boot/${KERNEL_IMAGETYPE} \
              --ramdisk ${B}/initrd.img \
              --output ${DEPLOYDIR}/${BOOT_IMAGE_BASE_NAME}.img \
              $mkbootimg_dtarg \
              --pagesize ${QCOM_BOOTIMG_PAGE_SIZE} \
              --base ${QCOM_BOOTIMG_KERNEL_BASE} \
              --cmdline \
              "root=/dev/${QCOM_BOOTIMG_ROOTFS} rw rootwait console=${ttydev},${baudrate}n8"

    ln -sf ${BOOT_IMAGE_BASE_NAME}.img ${DEPLOYDIR}/${BOOT_IMAGE_SYMLINK_NAME}.img
}
