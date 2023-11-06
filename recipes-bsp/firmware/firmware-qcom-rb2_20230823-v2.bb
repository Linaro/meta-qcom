DESCRIPTION = "QCOM Firmware for Qualcomm Robotics RB2 platform"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.qcom.txt;md5=cbbe399f2c983ad51768f4561587f000"

SRC_URI = "http://releases.linaro.org/96boards/rb2/qualcomm/firmware/RB2_firmware_${PV}.zip;subdir=${BP}"
SRC_URI[md5sum] = "53b6cda776cb534883e6c2a048ad97ec"
SRC_URI[sha256sum] = "5d96c6f224cd4667afd47770b6cd0ad2ad912fe67fec86f4478ad8dcffae8531"

FW_QCOM_NAME = "qrb4210"

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
