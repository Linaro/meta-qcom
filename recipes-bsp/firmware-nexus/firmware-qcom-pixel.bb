DESCRIPTION = "QCOM Firmware for Google Pixel / Pixel XL"

FW_QCOM_NAME = "sailfish"
FW_QCOM_SUBDIR = "msm8996/Google/${FW_QCOM_NAME}"
EXTRA_DEVICE_SUBDIR = "msm8996/Google/marlin"
AOSP_BUILD = "qp1a.191005.007.a3"
CHECKSUM_vendor = "a1615a0f"
CHECKSUM_factory = "d4552659"

SRC_URI[vendor.sha256sum] = "1cfffa986c4640a8bb3466f69a6f9bf511b4b6a8cb06fb0e1474a331e53876d6"
SRC_URI[factory.sha256sum] = "d455265945bb936a653730031af7d7a4aba70dc0c775024666a53491c9833b61"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a530"

require firmware-qcom-pixel.inc
RADIO_ROOTDIR = "1"
require firmware-qcom-radio.inc
