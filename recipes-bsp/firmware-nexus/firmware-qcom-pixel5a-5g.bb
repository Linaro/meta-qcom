DESCRIPTION = "QCOM Firmware for Google Pixel 5a 5G"

FW_QCOM_NAME = "barbet"
FW_QCOM_SUBDIR = "sm7250/Google/${FW_QCOM_NAME}"
AOSP_BUILD = "tp1a.221105.002"
CHECKSUM_vendor = "425252ac"

SRC_URI[vendor.sha256sum] = "72ccf1e403824214bfbfeccac55c865bb179b15ff50f9066f87bde4c925fbc27"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a650"

VENDOR_IMG_SPARSE = "0"
require firmware-qcom-pixel.inc
