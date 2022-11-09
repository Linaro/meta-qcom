DESCRIPTION = "QCOM Firmware for Google Pixel 4a (5G)"

FW_QCOM_NAME = "bramble"
FW_QCOM_SUBDIR = "sm7250/Google/${FW_QCOM_NAME}"
AOSP_BUILD = "sp2a.220405.003"
CHECKSUM_vendor = "395ecce2"

SRC_URI[vendor.sha256sum] = "fb89a8a4bb9baeb88512443f54454c473cb4524c049d50389eee49a93e3d6c67"

require firmware-qcom-pixel.inc
