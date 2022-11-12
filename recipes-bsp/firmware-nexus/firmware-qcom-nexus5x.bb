DESCRIPTION = "QCOM Firmware for LGE Google Nexus 5X"

LIC_FILES_CHKSUM = "file://license.txt;md5=76ab107d8eb5f8a7927011ac29447b4a"

FW_QCOM_NAME = "bullhead"
FW_QCOM_SUBDIR = "msm8992/LGE/${FW_QCOM_NAME}"
VENDOR = "lge"
AOSP_BUILD = "opm7.181205.001"
CHECKSUM_vendor = "bb4176a6"
CHECKSUM_factory = "5f189d84"

SRC_URI[vendor.sha256sum] = "eaba58f7219eb477697869454138d151b38a1589db1ab40cec1b4525774fe869"
SRC_URI[factory.sha256sum] = "5f189d84781a26b49aca0de84a941a32ae0150da0aab89f1d7709d56c31b3c0a"

require firmware-qcom-pixel.inc
RADIO_VFAT = "1"
require firmware-qcom-radio.inc
