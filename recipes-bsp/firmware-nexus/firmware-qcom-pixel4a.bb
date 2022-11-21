DESCRIPTION = "QCOM Firmware for Google Pixel 4a"

FW_QCOM_NAME = "sunfish"
FW_QCOM_SUBDIR = "sdm730/Google/${FW_QCOM_NAME}"
AOSP_BUILD = "tp1a.221105.002"
CHECKSUM_vendor = "6d6cfc6a"

SRC_URI[vendor.sha256sum] = "5013b1aad7ae7a0724f08e26bf73954464d8a314b8c10f21f4e62e49237907c5"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a630"

VENDOR_IMG_SPARSE = "0"
require firmware-qcom-pixel.inc
