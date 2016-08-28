DEPENDS += "skales-native"

BOOT_IMAGE_BASE_NAME ?= "boot-${KERNEL_IMAGE_BASE_NAME}"
BOOT_IMAGE_SYMLINK_NAME ?= "boot-${MACHINE}"

python __anonymous() {
    if d.getVar('SERIAL_CONSOLES', True):
        consoleargs = d.getVar('SERIAL_CONSOLES', True).split()[0].split(';')
        d.setVar('BOOTIMG_CMDLINE_CONSOLE', 'console={1},{0}n8'.format(consoleargs[0], consoleargs[1]))
    else:
        d.setVar('BOOTIMG_CMDLINE_CONSOLE', '')
    if d.getVar('DT_IMAGE_BASE_NAME', True):
        d.setVar('BOOTIMG_DT_ARG', '--dt ${DEPLOYDIR}/${DT_IMAGE_BASE_NAME}.img')
    else:
        d.setVar('BOOTIMG_DT_ARG', '')
}

BOOTIMG_CMDLINE ?= "${BOOTIMG_CMDLINE_ROOT} ${BOOTIMG_CMDLINE_CONSOLE}"

do_deploy() {

    kernel_do_deploy

    if [ -n "${DT_IMAGE_BASE_NAME}" ]; then
        dtbTool -o ${DEPLOYDIR}/${DT_IMAGE_BASE_NAME}.img -s ${BOOTIMG_PAGE_SIZE} ${B}/arch/${ARCH}/boot/dts/qcom/
    fi

    # mkbootimg requires an initrd file, make fake one that will be ignored
    # during boot
    echo "This is not an initrd" > ${B}/initrd.img

    mkbootimg --kernel ${B}/arch/${ARCH}/boot/${KERNEL_IMAGETYPE} \
              --ramdisk ${B}/initrd.img \
              --output ${DEPLOYDIR}/${BOOT_IMAGE_BASE_NAME}.img \
              ${BOOTIMG_DT_ARG} \
              --pagesize ${BOOTIMG_PAGE_SIZE} \
              --base ${BOOTIMG_BASE_ADDR} \
              --cmdline "${BOOTIMG_CMDLINE}"

    ln -sf ${BOOT_IMAGE_BASE_NAME}.img ${DEPLOYDIR}/${BOOT_IMAGE_SYMLINK_NAME}.img
    if [ -n "${DT_IMAGE_BASE_NAME}" ]; then
        ln -sf ${DT_IMAGE_BASE_NAME}.img ${DEPLOYDIR}/${DT_IMAGE_SYMLINK_NAME}.img
    fi
}
