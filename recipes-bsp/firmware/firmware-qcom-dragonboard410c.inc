DESCRIPTION = "QCOM Firmware for DragonBoard 410c"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4d087ee0965cb059f1b2f9429e166f64"

RRECOMMENDS_${PN} = "linux-firmware-qcom-apq8016-modem linux-firmware-qcom-apq8016-wifi"

FW_QCOM_NAME = "apq8016"

require recipes-bsp/firmware/firmware-qcom.inc

S = "${WORKDIR}/linux-board-support-package-r${PV}"

do_install() {
    install -d ${D}${FW_QCOM_PATH}

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}

    # compat for Linux kernel <= 5.15
    install -d ${D}${nonarch_base_libdir}/firmware/wlan/prima
    install -m 0644 ./proprietary-linux/wlan/prima/WCNSS_qcom_wlan_nv.bin \
                 ${D}${nonarch_base_libdir}/firmware/wlan/prima/

    install -d ${D}${FW_QCOM_BASE_PATH}/msm8916
    for file in modem.mbn mba.mbn wcnss.mbn
    do
        ln -s ../apq8016/$file ${D}${FW_QCOM_BASE_PATH}/msm8916/$file
    done
    for file in modem.mdt wcnss.mdt
    do
        ln -s ../apq8016/`basename $file .mdt`.mbn ${D}${FW_QCOM_BASE_PATH}/msm8916/$file
    done
}
