require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-dtb.inc

DESCRIPTION = "Hisilicon 3.18 Kernel"

PV = "4.0.0+git${SRCPV}"
SRCREV_kernel="7b59de360b2a092bf3afe068df52ee17e848fa5a"

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
