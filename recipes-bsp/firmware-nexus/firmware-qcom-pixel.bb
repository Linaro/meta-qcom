DESCRIPTION = "QCOM Firmware for Google Pixel / Pixel XL"

FW_QCOM_NAME = "sailfish"
FW_QCOM_SUBDIR = "msm8996/Google/${FW_QCOM_NAME}"
EXTRA_DEVICE_SUBDIR = "msm8996/Google/marlin"
AOSP_BUILD = "qp1a.191005.007.a3"
CHECKSUM_vendor = "a1615a0f"

SRC_URI[vendor.sha256sum] = "1cfffa986c4640a8bb3466f69a6f9bf511b4b6a8cb06fb0e1474a331e53876d6"

require firmware-qcom-pixel.inc
