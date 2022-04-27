DESCRIPTION = "QCOM Firmware for Google Pixel 5"

FW_QCOM_NAME = "redfin"
AOSP_BUILD = "sp2a.220405.003"
CHECKSUM_vendor = "2ab4bdce"

SRC_URI[vendor.sha256sum] = "8c2bc955e6ca0e32f7460b669a972e8dfac85fe3b649e0bed47c5ef9790ebb53"

require firmware-qcom-pixel.inc
