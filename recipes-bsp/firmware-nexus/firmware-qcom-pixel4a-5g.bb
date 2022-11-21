DESCRIPTION = "QCOM Firmware for Google Pixel 4a (5G)"

FW_QCOM_NAME = "bramble"
FW_QCOM_SUBDIR = "sm7250/Google/${FW_QCOM_NAME}"
AOSP_BUILD = "tp1a.221105.002"
CHECKSUM_vendor = "793c7b07"

SRC_URI[vendor.sha256sum] = "b643f4f01a87750094049e0854abc6f2b506560bdc556fcc449eb9c2ff19038e"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a650"

VENDOR_IMG_SPARSE = "0"
require firmware-qcom-pixel.inc
