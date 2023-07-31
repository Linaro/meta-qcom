DESCRIPTION = "QCOM Firmware for Qualcomm Robotics RB2 platform"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.qcom.txt;md5=cbbe399f2c983ad51768f4561587f000"

SRC_URI = "http://releases.linaro.org/96boards/rb2/qualcomm/firmware/RB2_firmware_${PV}.zip;subdir=${BP}"
SRC_URI[md5sum] = "4f41d580ad42050009eea47cb563405e"
SRC_URI[sha256sum] = "f72dd781008c9b4e3423e93696a2f62746ff681837bc3641cdf3c3338aed0e6b"

DEPENDS += "pil-squasher-native"

FW_QCOM_NAME = "qrb4210"

require recipes-bsp/firmware/firmware-qcom.inc

do_compile:append() {
    pil-squasher 10-cdsp_split/cdsp.mbn 10-cdsp_split/cdsp.mdt
    pil-squasher 11-adreno-fw/a610_zap.mbn 11-adreno-fw/a610_zap.mdt
    pil-squasher 13-adsp_split/adsp.mbn 13-adsp_split/adsp.mdt
    pil-squasher 34-modem/modem.mbn 34-modem/modem.mdt
}

do_install() {
    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE.qcom.txt ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}

    install -d ${D}${FW_QCOM_PATH}

    install -m 0444 04-dspso/dspso.bin ${D}${FW_QCOM_PATH}

    install -m 0444 10-cdsp_split/cdsp.mbn ${D}${FW_QCOM_PATH}
    install -m 0444 11-adreno-fw/a610_zap.mbn ${D}${FW_QCOM_PATH}
    install -m 0444 13-adsp_split/adsp.mbn ${D}${FW_QCOM_PATH}
    install -m 0444 34-modem/modem.mbn ${D}${FW_QCOM_PATH}

    # The file is installed in rb1 firmware recipe
    ln -s ../../ath10k/WCN3990/hw1.0/wlanmdsp-rb12.mbn ${D}${FW_QCOM_PATH}/wlanmdsp.mbn

    install -m 0444 23-jsn/*jsn ${D}${FW_QCOM_PATH}
}

RDEPENDS_linux-firmware-qcom-${FW_QCOM_NAME}-wifi += "linux-firmware-ath10k-wlanmdsp-rb12"

SPLIT_FIRMWARE_PACKAGES = " \
    ${PN}-dspso \
    linux-firmware-qcom-${FW_QCOM_NAME}-adreno \
    linux-firmware-qcom-${FW_QCOM_NAME}-audio \
    linux-firmware-qcom-${FW_QCOM_NAME}-compute \
    linux-firmware-qcom-${FW_QCOM_NAME}-modem \
    linux-firmware-qcom-${FW_QCOM_NAME}-wifi \
"
