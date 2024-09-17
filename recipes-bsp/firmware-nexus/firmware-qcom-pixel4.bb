DESCRIPTION = "QCOM Firmware for Google Pixel 4 / 4 XL"

FW_QCOM_NAME = "flame"
FW_QCOM_SUBDIR = "sm8150/Google/${FW_QCOM_NAME}"
EXTRA_DEVICE_SUBDIR = "sm8150/Google/coral"
AOSP_BUILD = "tp1a.221005.002.b2"
CHECKSUM_vendor = "22399ead"

SRC_URI[vendor.sha256sum] = "fc2bc6cd2fde8d96641d624d68260b5392ad62e3d031d81659fad21d654f57e0"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a630"

VENDOR_IMG_SPARSE = "0"
require firmware-qcom-pixel.inc
