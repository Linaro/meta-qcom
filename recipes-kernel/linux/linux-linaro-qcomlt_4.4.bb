# Copyright (C) 2014 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 4.4 Kernel"

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "release/qcomlt-4.4"
SRCREV ?= "40e98b46d2d547c44ad1d0a0125cf4c6f963a3d4"
PV .= "+git${SRCPV}"

COMPATIBLE_MACHINE = "(ifc6410|sd-600eval|dragonboard-410c)"

KERNEL_CONFIG_FRAGMENTS += "${S}/kernel/configs/distro.config"

# append DTB, since bootloader doesn't support DTB
do_compile_append_apq8064() {
    if ! [ -e ${B}/arch/${ARCH}/boot/dts/${KERNEL_DEVICETREE} ] ; then
        oe_runmake ${KERNEL_DEVICETREE}
    fi
    cp arch/${ARCH}/boot/zImage arch/${ARCH}/boot/zImage.backup
    cat arch/${ARCH}/boot/zImage.backup arch/${ARCH}/boot/dts/${KERNEL_DEVICETREE} > arch/${ARCH}/boot/zImage
    rm -f arch/${ARCH}/boot/zImage.backup
}

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
