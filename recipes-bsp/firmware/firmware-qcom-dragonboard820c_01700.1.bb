DESCRIPTION = "QCOM Firmware for DragonBoard 820c"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4d087ee0965cb059f1b2f9429e166f64"

SRC_URI = "https://releases.linaro.org/96boards/dragonboard820c/qualcomm/firmware/linux-board-support-package-r${PV}.zip"
SRC_URI[md5sum] = "587138c5e677342db9a88d5c8747ec6c"
SRC_URI[sha256sum] = "6ee9c461b2b5dd2d3bd705bb5ea3f44b319ecb909b2772f305ce12439e089cd9"

FW_QCOM_NAME = "apq8096"

require recipes-bsp/firmware/firmware-qcom.inc

S = "${WORKDIR}/linux-board-support-package-r${PV}"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/
    install -d ${D}${FW_QCOM_PATH}/
    
    install -m 0444 ./bootloaders-linux/adspso.bin ${D}${FW_QCOM_PATH}/

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}
}

SPLIT_FIRMWARE_PACKAGES = " \
    ${PN}-dspso \
"
