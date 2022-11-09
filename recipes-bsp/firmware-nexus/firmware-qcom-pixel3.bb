DESCRIPTION = "QCOM Firmware for Google Pixel 3 / 3 XL"

FW_QCOM_NAME = "blueline"
FW_QCOM_SUBDIR = "sdm845/Google/${FW_QCOM_NAME}"
EXTRA_DEVICE_SUBDIR = "sdm845/Google/crosshatch"
AOSP_BUILD = "sp1a.210812.016.c1"
CHECKSUM_vendor = "0b9f3bc0"

SRC_URI[vendor.sha256sum] = "5e48f4769d3cdba3c958f956d13df56b60e18e8fe03893d38f4125b421ab7ff9"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a630"

require firmware-qcom-pixel.inc
