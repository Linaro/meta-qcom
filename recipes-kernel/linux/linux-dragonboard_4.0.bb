require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-dtb.inc

DESCRIPTION = "Linaro Qualcomm Landing team 4.0 Kernel"

PV = "4.0.0+git${SRCPV}"
SRCREV_kernel="f8a46972ba59f51cbda34f4e9eee6b4d1fbe2731"

SRC_URI = "git://git.linaro.org/landing-teams/working/qualcomm/kernel.git;name=kernel;protocol=http;branch=release/qcomlt-4.0 \
           file://defconfig \
          "
S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "dragonboard-410c"
KERNEL_IMAGETYPE ?= "Image"

KERNEL_CONFIG_FRAGMENTS += "${S}/kernel/configs/distro.config"

KERNEL_DEVICETREE = "qcom/apq8016-sbc.dtb"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
