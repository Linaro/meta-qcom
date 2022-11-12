DESCRIPTION = "QCOM Firmware for Motorola Google Nexus 6"

FW_QCOM_NAME = "shamu"
FW_QCOM_SUBDIR = "apq8084/Motorola/${FW_QCOM_NAME}"
AOSP_BUILD = "ngi77b"
CHECKSUM_qcom = "b5a5aacc"

SRC_URI[qcom.sha256sum] = "811ccc3c8bd4b832a26fc36aac5a46af7000d849c7217032e1d0819bfb2000dc"

require recipes-bsp/firmware-nexus/firmware-qcom-nexus.inc

do_install:append() {
    install -d ${D}${FW_QCOM_PATH}

    install -m 0644 adsp.mbn ${D}${FW_QCOM_PATH}
    install -m 0644 venus.mbn ${D}${FW_QCOM_PATH}
}
