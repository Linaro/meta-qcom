# Copyright (C) 2014 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-dtb.inc

KERNEL_DEVICETREE = "qcom-apq8064-ifc6410.dtb"
SRCBRANCH = "release/qcomlt-3.18"
SRCREV = "c52abe0a3e606e343c7410faf8d39d06b4460857"

# fixup.bin needs to be prepended to zImage to fixup the atag mem info because of broken bootloaders.
# Without this a panic will occur upon freeing bootmem.
do_compile_append() {
    if [ -e "fixup.bin" ]; then
        cp ${KERNEL_OUTPUT} ${KERNEL_OUTPUT}.backup
        cat "fixup.bin" ${KERNEL_OUTPUT}.backup > ${KERNEL_OUTPUT}
        rm -f ${KERNEL_OUTPUT}.backup
    fi
}
