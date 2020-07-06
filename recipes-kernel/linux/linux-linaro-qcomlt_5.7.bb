# Copyright (C) 2014-2019 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 5.7 Kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit python3native

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

SRC_URI_append_qrb5165-rb5 = " \
    file://qrb5165-rb5.dts;subdir=git/arch/arm64/boot/dts/qcom \
    file://qrb5165-rb5-enable.patch \
    file://0001-arm64-dts-qcom-sm8250-change-spmi-node-label.patch \
    file://0001-arm64-dts-qcom-sm8250-add-I2C-and-SPI-nodes.patch \
    file://0001-arm64-dts-qcom-sm8250-Add-USB-and-PHY-device-nodes.patch \
    file://0001-arm64-dts-qcom-sm8250-Rename-UART2-node-to-UART12.patch \
    file://0001-arm64-dts-qcom-sm8250-Add-support-for-SDC2.patch \
"

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "release/qcomlt-5.7"
SRCREV ?= "21bb88052948b35bdce926f301f2ba7970040812"

COMPATIBLE_MACHINE = "(apq8016|apq8096|sdm845|sm8250)"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
