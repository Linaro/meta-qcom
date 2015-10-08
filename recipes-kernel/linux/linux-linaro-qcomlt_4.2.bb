# Copyright (C) 2014 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 4.2 Kernel"

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

SRCBRANCH = "release/qcomlt-4.2"
SRCREV = "d3a8cef5d9a3eaa2b8e0f9f95e82354a40fac528"
SRC_URI += "file://defconfig"

COMPATIBLE_MACHINE = "(ifc6410|dragonboard-410c)"

KERNEL_CONFIG_FRAGMENTS += "${S}/kernel/configs/distro.config"
KERNEL_IMAGETYPE_dragonboard-410c ?= "Image"
KERNEL_DEVICETREE_dragonboard-410c = "qcom/apq8016-sbc.dtb"

# fixup.bin needs to be prepended to zImage to fixup the atag mem info because of broken bootloaders.
# Without this a panic will occur upon freeing bootmem.
do_compile_append_ifc6410() {
    if [ -e "fixup.bin" ]; then
        cp ${KERNEL_OUTPUT} ${KERNEL_OUTPUT}.backup
        cat "fixup.bin" ${KERNEL_OUTPUT}.backup > ${KERNEL_OUTPUT}
        rm -f ${KERNEL_OUTPUT}.backup
    fi
}

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"

QCOM_BOOTIMG_ROOTFS_dragonboard-410c = "mmcblk0p10"
QCOM_BOOTIMG_ROOTFS_ifc6410 = "mmcblk0p12"
