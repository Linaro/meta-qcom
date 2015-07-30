# Copyright (C) 2014 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-dtb.inc

SRCBRANCH = "release/qcomlt-3.19"
SRCREV = "ce5c75ed2a5bf6530ce5c0bcd6b38e5cd3affcd4"

# Limit to ifc6410 machine
COMPATIBLE_MACHINE = "(ifc6410)"

KERNEL_CONFIG_FRAGMENTS += "${S}/kernel/configs/distro.config"

# fixup.bin needs to be prepended to zImage to fixup the atag mem info because of broken bootloaders.
# Without this a panic will occur upon freeing bootmem.
do_compile_append() {
    if [ -e "fixup.bin" ]; then
        cp ${KERNEL_OUTPUT} ${KERNEL_OUTPUT}.backup
        cat "fixup.bin" ${KERNEL_OUTPUT}.backup > ${KERNEL_OUTPUT}
        rm -f ${KERNEL_OUTPUT}.backup
    fi
}
