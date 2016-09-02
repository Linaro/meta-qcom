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

COMPATIBLE_MACHINE = "(apq8064|apq8016|apq8096)"

KERNEL_DEFCONFIG_aarch64 ?= "${S}/arch/arm64/configs/defconfig"
KERNEL_DEFCONFIG_apq8064 ?= "${S}/arch/arm/configs/qcom_defconfig"
KERNEL_CONFIG_FRAGMENTS += "${S}/kernel/configs/distro.config"

# Wifi firmware has a recognizable arch :(
ERROR_QA_remove = "arch"

QCOM_BOOTIMG_ROOTFS_dragonboard-410c = "mmcblk0p10"
QCOM_BOOTIMG_ROOTFS_dragonboard-820c = "sde18"
QCOM_BOOTIMG_ROOTFS_ifc6410 = "mmcblk0p12"
QCOM_BOOTIMG_ROOTFS_sd-600eval = "mmcblk0p12"
