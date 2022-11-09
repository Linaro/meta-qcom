DESCRIPTION = "QCOM Firmware for Google Pixel 5a 5G"

FW_QCOM_NAME = "barbet"
FW_QCOM_SUBDIR = "sm7250/Google/${FW_QCOM_NAME}"
AOSP_BUILD = "sp2a.220405.003"
CHECKSUM_vendor = "c3cdaef9"

SRC_URI[vendor.sha256sum] = "93b12611038f8c54d3a57f95906839ed1c3315a6b47e0883cf1890dfca6eb728"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a650"

require firmware-qcom-pixel.inc
