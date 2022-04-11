DESCRIPTION = "QCOM Firmware for LGE Google Nexus 5X"

LIC_FILES_CHKSUM = "file://license.txt;md5=76ab107d8eb5f8a7927011ac29447b4a"

FW_QCOM_NAME = "bullhead"
VENDOR = "lge"
AOSP_BUILD = "opm7.181205.001"
CHECKSUM_vendor = "bb4176a6"

SRC_URI[vendor.sha256sum] = "eaba58f7219eb477697869454138d151b38a1589db1ab40cec1b4525774fe869"

require recipes-bsp/firmware-nexus/firmware-qcom-pixel.inc
