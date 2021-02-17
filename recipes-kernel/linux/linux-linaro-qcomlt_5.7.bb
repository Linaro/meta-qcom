# Copyright (C) 2014-2019 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-linaro-qcom.inc

inherit python3native

SRC_URI_append_qrb5165-rb5 = " \
    file://qrb5165-rb5.dts;subdir=git/arch/arm64/boot/dts/qcom \
    file://qrb5165-rb5-enable.patch \
    file://0001-arm64-dts-qcom-sm8250-change-spmi-node-label.patch \
    file://0001-arm64-dts-qcom-sm8250-add-I2C-and-SPI-nodes.patch \
    file://0001-arm64-dts-qcom-sm8250-Add-USB-and-PHY-device-nodes.patch \
    file://0001-arm64-dts-qcom-sm8250-Rename-UART2-node-to-UART12.patch \
    file://0001-arm64-dts-qcom-sm8250-Add-support-for-SDC2.patch \
"

SRCREV ?= "4af49ea41ecf17e5e6243f3ac81dfc2f84d8a3a1"
