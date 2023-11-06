DESCRIPTION = "QCOM Firmware for Qualcomm Robotics RB1 platform"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.qcom.txt;md5=cbbe399f2c983ad51768f4561587f000"

SRC_URI = "http://releases.linaro.org/96boards/rb1/qualcomm/firmware/RB1_firmware_${PV}.zip;subdir=${BP}"
SRC_URI[md5sum] = "db892ca115845938c6672d756448d512"
SRC_URI[sha256sum] = "e7f95cc61d601f6267f87741c333ec5663a6fb538c79770dc094c2556fa757c0"

FW_QCOM_NAME = "qcm2290"

require recipes-bsp/firmware/firmware-qcom.inc

do_install() {
    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE.qcom.txt ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}

    install -d ${D}${FW_QCOM_PATH}

    install -m 0444 04-dspso/dspso.bin ${D}${FW_QCOM_PATH}
}

SPLIT_FIRMWARE_PACKAGES = " \
    ${PN}-dspso \
"
