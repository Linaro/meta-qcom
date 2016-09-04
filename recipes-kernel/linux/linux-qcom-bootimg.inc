DEPENDS += "skales-native"

QCOM_BOOTIMG_ROOTFS ?= "undefined"
QCOM_BOOTIMG_ROOTFS_dragonboard-410c = "mmcblk0p10"
QCOM_BOOTIMG_ROOTFS_dragonboard-820c = "sde18"
QCOM_BOOTIMG_ROOTFS_ifc6410 = "mmcblk0p12"
QCOM_BOOTIMG_ROOTFS_sd-600eval = "mmcblk0p12"

QCOM_BOOTIMG_BUNDLE_DT = "1"
QCOM_BOOTIMG_BUNDLE_DT_apq8064 = "0"
QCOM_BOOTIMG_KERNEL_BASE = "0x80000000"
QCOM_BOOTIMG_KERNEL_BASE_apq8064 = "0x80200000"

# set output file names
DT_IMAGE_BASE_NAME = "dt-${KERNEL_IMAGE_BASE_NAME}"
DT_IMAGE_SYMLINK_NAME = "dt-${KERNEL_IMAGE_SYMLINK_NAME}"
BOOT_IMAGE_BASE_NAME = "boot-${KERNEL_IMAGE_BASE_NAME}"
BOOT_IMAGE_SYMLINK_NAME = "boot-${KERNEL_IMAGE_SYMLINK_NAME}"

# append DTB if bootloader doesn't support DTB
do_compile_append() {
    if [ "${QCOM_BOOTIMG_BUNDLE_DT}" != "1" ]; then
        if ! [ -e ${B}/arch/${ARCH}/boot/dts/${KERNEL_DEVICETREE} ] ; then
            oe_runmake ${KERNEL_DEVICETREE}
        fi
        cp arch/${ARCH}/boot/${KERNEL_IMAGETYPE} arch/${ARCH}/boot/${KERNEL_IMAGETYPE}.backup
        cat arch/${ARCH}/boot/${KERNEL_IMAGETYPE}.backup arch/${ARCH}/boot/dts/${KERNEL_DEVICETREE} > arch/${ARCH}/boot/${KERNEL_IMAGETYPE}
        rm -f arch/${ARCH}/boot/${KERNEL_IMAGETYPE}.backup
    fi
}

do_deploy_append() {

    mkbootimg_dtarg=""
    if [ "${QCOM_BOOTIMG_BUNDLE_DT}" = "1" ]; then
        dtbTool -o ${DEPLOYDIR}/${DT_IMAGE_BASE_NAME}.img -s 2048 ${B}/arch/${ARCH}/boot/dts/qcom/
        mkbootimg_dtarg="--dt ${DEPLOYDIR}/${DT_IMAGE_BASE_NAME}.img"
    fi

    tmp="${SERIAL_CONSOLES}"
    baudrate=`echo $tmp | sed 's/\;.*//'`
    ttydev=`echo $tmp | sed -e 's/^[0-9]*\;//' -e 's/\s.*//' -e 's/\;.*//'`

    # mkbootimg requires an initrd file, make fake one that will be ignored
    # during boot
    echo "This is not an initrd" > ${B}/initrd.img

    mkbootimg --kernel ${B}/arch/${ARCH}/boot/${KERNEL_IMAGETYPE} \
              --ramdisk ${B}/initrd.img \
              --output ${DEPLOYDIR}/${BOOT_IMAGE_BASE_NAME}.img \
              $mkbootimg_dtarg \
              --pagesize 2048 \
              --base ${QCOM_BOOTIMG_KERNEL_BASE} \
              --cmdline \
              "root=/dev/${QCOM_BOOTIMG_ROOTFS} rw rootwait console=${ttydev},${baudrate}n8"

    if [ "${QCOM_BOOTIMG_BUNDLE_DT}" = "1" ]; then
        ln -sf ${DT_IMAGE_BASE_NAME}.img ${DEPLOYDIR}/${DT_IMAGE_SYMLINK_NAME}.img
    fi
    ln -sf ${BOOT_IMAGE_BASE_NAME}.img ${DEPLOYDIR}/${BOOT_IMAGE_SYMLINK_NAME}.img
}
