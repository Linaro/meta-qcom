DESCRIPTION = "QCOM Firmware for Google Pixel 5"

FW_QCOM_NAME = "redfin"
FW_QCOM_SUBDIR = "sm7250/Google/${FW_QCOM_NAME}"
AOSP_BUILD = "up1a.231105.001.b2"
CHECKSUM_vendor = "dba16b6b"

SRC_URI[vendor.sha256sum] = "88ee57049e92d007815195439ebd109e4db6827a6c0b5867e1b2bfaf88421115"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a650"

VENDOR_IMG_SPARSE = "0"
require firmware-qcom-pixel.inc
