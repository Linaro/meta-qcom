DESCRIPTION = "QCOM Firmware for Google Pixel 4a (5G)"

FW_QCOM_NAME = "bramble"
AOSP_BUILD = "sp2a.220405.003"
CHECKSUM_vendor = "395ecce2"

SRC_URI[vendor.sha256sum] = "fb89a8a4bb9baeb88512443f54454c473cb4524c049d50389eee49a93e3d6c67"

require recipes-bsp/firmware-nexus/firmware-qcom-pixel.inc
