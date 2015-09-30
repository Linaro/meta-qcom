python __anonymous () {
    depends = d.getVar("DEPENDS", True)
    depends = "%s skales-native" % depends
    d.setVar("DEPENDS", depends)
}

QCOM_BOOTIMG_ROOTFS ?= "undefined"

do_deploy_append_dragonboard-410c() {

    DT_IMG_NAME="dt-${PKGE}-${PKGV}-${PKGR}-${MACHINE}-${DATETIME}"
    BOOT_IMG_NAME="boot-${PKGE}-${PKGV}-${PKGR}-${MACHINE}-${DATETIME}"

    dtbTool -o ${DEPLOYDIR}/${DT_IMG_NAME}.img -s 2048 ${B}/arch/${ARCH}/boot/dts/qcom/

    tmp="${SERIAL_CONSOLES}"
    baudrate=`echo $tmp | sed 's/\;.*//'`
    ttydev=`echo $tmp | sed -e 's/^[0-9]*\;//' -e 's/\s.*//' -e 's/\;.*//'`

    # mkbootimg requires an initrd file, make fake one that will be ignored
    # during boot
    echo "This is not an initrd" > ${B}/initrd.img

    mkbootimg --kernel ${B}/arch/${ARCH}/boot/Image \
              --ramdisk ${B}/initrd.img \
              --output ${DEPLOYDIR}/${BOOT_IMG_NAME}.img \
              --dt ${DEPLOYDIR}/${DT_IMG_NAME}.img \
              --pagesize 2048 \
              --base 0x80000000 \
              --cmdline \
              "root=/dev/${QCOM_BOOTIMG_ROOTFS} rw rootwait console=${ttydev},${baudrate}n8"

    cd ${DEPLOYDIR}
	ln -sf ${DT_IMG_NAME}.img dt-${MACHINE}.img
	ln -sf ${BOOT_IMG_NAME}.img boot-${MACHINE}.img
    cd -
}
