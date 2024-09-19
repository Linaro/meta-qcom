DESCRIPTION = "QCOM Firmware for Google Pixel 5a 5G"

FW_QCOM_NAME = "barbet"
FW_QCOM_SUBDIR = "sm7250/Google/${FW_QCOM_NAME}"
AOSP_BUILD = "ap2a.240805.005"
CHECKSUM_vendor = "a0da9c40"

SRC_URI[vendor.sha256sum] = "d1ac39e330b281f95640bc2f44a8901ac6e5359cd9954220cbee82bc8a8df50b"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a650"

VENDOR_IMG_SPARSE = "0"
require firmware-qcom-pixel.inc
