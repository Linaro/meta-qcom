# Copyright (C) 2014 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 4.4 Kernel"

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "integration-linux-qcomlt"
SRCREV ?= "5574089362de2fb0ebbc0c4d9bd48203b59b7b1b"
SRC_URI = "${LINUX_LINARO_QCOM_GIT};nobranch=1"
PV .= "+git${SRCPV}"

COMPATIBLE_MACHINE = "(apq8064|apq8016|apq8096)"

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
