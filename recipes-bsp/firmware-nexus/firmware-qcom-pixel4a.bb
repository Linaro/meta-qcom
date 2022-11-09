DESCRIPTION = "QCOM Firmware for Google Pixel 4a"

FW_QCOM_NAME = "sunfish"
FW_QCOM_SUBDIR = "sdm730/Google/${FW_QCOM_NAME}"
AOSP_BUILD = "sp2a.220405.003"
CHECKSUM_vendor = "5acbf701"

SRC_URI[vendor.sha256sum] = "ed16536e4de2714ef237f350343d38226199417f286d31de7ebfa0a95784ee2b"

require firmware-qcom-pixel.inc
