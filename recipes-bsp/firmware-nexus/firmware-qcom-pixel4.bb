DESCRIPTION = "QCOM Firmware for Google Pixel 4 / 4 XL"

FW_QCOM_NAME = "flame"
EXTRA_DEVICE_NAME = "coral"
AOSP_BUILD = "sp2a.220405.003"
CHECKSUM_vendor = "ead1b1a8"

SRC_URI[vendor.sha256sum] = "8e919f063cd753948c12e0aee386cb8a86d905039ea45668e7fe6bc62bd08aca"

require recipes-bsp/firmware-nexus/firmware-qcom-pixel.inc
