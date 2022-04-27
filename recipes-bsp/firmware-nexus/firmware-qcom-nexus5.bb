DESCRIPTION = "QCOM Firmware for LGE Google Nexus 5"

FW_QCOM_NAME = "hammerhead"
AOSP_BUILD = "m4b30z"
CHECKSUM_qcom = "d6c0fe26"

SRC_URI[qcom.sha256sum] = "f8c29461e279b311958f9476ef78b9ab654aeb9903f5c2912f11d5d4bcfd021d"

require recipes-bsp/firmware-nexus/firmware-qcom-nexus.inc
