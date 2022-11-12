DESCRIPTION = "QCOM Firmware for Google Pixel 5"

FW_QCOM_NAME = "redfin"
FW_QCOM_SUBDIR = "sm7250/Google/${FW_QCOM_NAME}"
AOSP_BUILD = "tp1a.221105.002"
CHECKSUM_vendor = "2b78e8a6"

SRC_URI[vendor.sha256sum] = "e2ab6c9024c282ace3fca7d66522075c4fc5188bcb00b3fb9dd8230056aef93f"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a650"

VENDOR_IMG_SPARSE = "0"
require firmware-qcom-pixel.inc
