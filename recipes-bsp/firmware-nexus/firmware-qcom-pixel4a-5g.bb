DESCRIPTION = "QCOM Firmware for Google Pixel 4a (5G)"

FW_QCOM_NAME = "bramble"
FW_QCOM_SUBDIR = "sm7250/Google/${FW_QCOM_NAME}"
AOSP_BUILD = "up1a.231105.001.b2"
CHECKSUM_vendor = "b7190494"

SRC_URI[vendor.sha256sum] = "6af72bf8bcef38fc9f4ecdeb6641c635189d9fd337abbc8772431a6944dc6199"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a650"

VENDOR_IMG_SPARSE = "0"
require firmware-qcom-pixel.inc
