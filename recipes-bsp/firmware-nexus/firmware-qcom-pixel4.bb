DESCRIPTION = "QCOM Firmware for Google Pixel 4 / 4 XL"

FW_QCOM_NAME = "flame"
FW_QCOM_SUBDIR = "sm8150/Google/${FW_QCOM_NAME}"
EXTRA_DEVICE_SUBDIR = "sm8150/Google/coral"
AOSP_BUILD = "tp1a.221005.002"
CHECKSUM_vendor = "bed97aaa"

SRC_URI[vendor.sha256sum] = "6644a17f9a5ac25b7f63fa3130b8ab0b8dbe768915fabadce3da9cab5dd39e35"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a630"

VENDOR_IMG_SPARSE = "0"
require firmware-qcom-pixel.inc
