DESCRIPTION = "QCOM Firmware for LGE Google Nexus 6P"

LIC_FILES_CHKSUM = "file://license.txt;md5=ab57c77a2230b7254cd6be1f1c0d6806"

FW_QCOM_NAME = "angler"
FW_QCOM_SUBDIR = "msm8994/Huawei/${FW_QCOM_NAME}"
VENDOR = "huawei"
AOSP_BUILD = "opm7.181205.001"
CHECKSUM_vendor = "52ed73ce"

SRC_URI[vendor.sha256sum] = "2eb9a77de059739d33c7fad07e34034f03a93d70eea39460bb0d9278e5763053"

require firmware-qcom-pixel.inc
