DESCRIPTION = "QCOM Firmware for Qualcomm Robotics RB1 platform"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.qcom.txt;md5=cbbe399f2c983ad51768f4561587f000"

SRC_URI = "http://releases.linaro.org/96boards/rb1/qualcomm/firmware/RB1_firmware_${PV}.zip;subdir=${BP}"
SRC_URI[md5sum] = "e2b940a74de03372f5f31ea4b1eb581b"
SRC_URI[sha256sum] = "525fa292bbe605574f41c1b09204db907ccde6fb7fb78bda88837979821a762f"

DEPENDS += "pil-squasher-native mtools-native"

FW_QCOM_NAME = "qcm2290"

require recipes-bsp/firmware/firmware-qcom.inc

do_compile:append() {
    pil-squasher 10-adreno-fw/a702_zap.mbn 10-adreno-fw/a702_zap.mdt
    pil-squasher 12-adsp_split/adsp.mbn 12-adsp_split/adsp.mdt
    pil-squasher 17-venus_split/venus.mbn 17-venus_split/venus.mdt
    pil-squasher 33-modem/modem.mbn 33-modem/modem.mdt

    mcopy -i 06-non-hlos/NON-HLOS.bin ::/image/wlanmdsp.mbn wlanmdsp.mbn
}

ATH10K_PATH = "${nonarch_base_libdir}/firmware/ath10k/WCN3990/hw1.0"

do_install() {
    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE.qcom.txt ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}

    install -d ${D}${FW_QCOM_PATH}

    install -m 0444 04-dspso/dspso.bin ${D}${FW_QCOM_PATH}

    install -m 0444 10-adreno-fw/a702_zap.mbn ${D}${FW_QCOM_PATH}
    install -m 0444 12-adsp_split/adsp.mbn ${D}${FW_QCOM_PATH}
    install -m 0444 33-modem/modem.mbn ${D}${FW_QCOM_PATH}

    install -m 0444 22-jsn/*jsn ${D}${FW_QCOM_PATH}

    install -d ${D}${ATH10K_PATH}
    install -m 0444 wlanmdsp.mbn ${D}${ATH10K_PATH}/wlanmdsp-rb12.mbn
    ln -s ../../ath10k/WCN3990/hw1.0/wlanmdsp-rb12.mbn ${D}${FW_QCOM_PATH}/wlanmdsp.mbn

    install -d ${D}${FW_QCOM_BASE_PATH}/venus-6.0
    install -m 0444 17-venus_split/venus.mbn ${D}${FW_QCOM_BASE_PATH}/venus-6.0
}

SPLIT_FIRMWARE_PACKAGES = " \
    ${PN}-dspso \
    linux-firmware-qcom-${FW_QCOM_NAME}-adreno \
    linux-firmware-qcom-${FW_QCOM_NAME}-audio \
    linux-firmware-qcom-${FW_QCOM_NAME}-modem \
    linux-firmware-qcom-${FW_QCOM_NAME}-wifi \
    linux-firmware-ath10k-wlanmdsp-rb12 \
    linux-firmware-qcom-venus-6.0 \
"

FILES:linux-firmware-ath10k-wlanmdsp-rb12 = "${ATH10K_PATH}"
FILES:linux-firmware-qcom-venus-6.0 = "${FW_QCOM_BASE_PATH}/venus-6.0"
