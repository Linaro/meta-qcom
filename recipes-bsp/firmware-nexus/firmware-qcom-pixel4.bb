DESCRIPTION = "QCOM Firmware for Google Pixel 4 / 4 XL"

FW_QCOM_NAME = "flame"
FW_QCOM_SUBDIR = "sm8150/Google/${FW_QCOM_NAME}"
EXTRA_DEVICE_SUBDIR = "sm8150/Google/coral"
AOSP_BUILD = "sp2a.220405.003"
CHECKSUM_vendor = "ead1b1a8"

SRC_URI[vendor.sha256sum] = "8e919f063cd753948c12e0aee386cb8a86d905039ea45668e7fe6bc62bd08aca"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a630"

require firmware-qcom-pixel.inc
