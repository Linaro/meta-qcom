DESCRIPTION = "QCOM Firmware for Motorola Google Nexus 6"

FW_QCOM_NAME = "shamu"
AOSP_BUILD = "ngi77b"
CHECKSUM_qcom = "b5a5aacc"

SRC_URI[qcom.sha256sum] = "811ccc3c8bd4b832a26fc36aac5a46af7000d849c7217032e1d0819bfb2000dc"

require recipes-bsp/firmware-nexus/firmware-qcom-nexus.inc
