DESCRIPTION = "QCOM Firmware for DragonBoard 410c"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4d087ee0965cb059f1b2f9429e166f64"

DEPENDS += "mtools-native pil-squasher-native"

FW_QCOM_NAME = "apq8016"

require recipes-bsp/firmware/firmware-qcom.inc

S = "${WORKDIR}/linux-board-support-package-r${PV}"

do_install() {
    install -d ${D}${FW_QCOM_PATH}

    install -m 0644 ./proprietary-linux/wlan/prima/WCNSS_qcom_wlan_nv.bin \
                 ${D}${FW_QCOM_PATH}/WCNSS_qcom_wlan_nv_sbc.bin

    MTOOLS_SKIP_CHECK=1 mcopy -i ./bootloaders-linux/NON-HLOS.bin \
    ::image/modem.* ::image/mba.mbn ::image/wcnss.* ${D}${FW_QCOM_PATH}

    pil-squasher ${D}${FW_QCOM_PATH}/modem.mbn \
                 ${D}${FW_QCOM_PATH}/modem.mdt

    pil-squasher ${D}${FW_QCOM_PATH}/wcnss.mbn \
                 ${D}${FW_QCOM_PATH}/wcnss.mdt

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}

    # compat for Linux kernel <= 5.15
    install -d ${D}${nonarch_base_libdir}/firmware/wlan/prima
    install -m 0644 ./proprietary-linux/wlan/prima/WCNSS_qcom_wlan_nv.bin \
                 ${D}${nonarch_base_libdir}/firmware/wlan/prima/

    install -d ${D}${FW_QCOM_BASE_PATH}/msm8916
    for file in ${D}${FW_QCOM_PATH}/*.mbn ${D}${FW_QCOM_PATH}/*.mdt ${D}${FW_QCOM_PATH}/*.b*
    do
        ln -s ../apq8016/$(basename $file) ${D}${FW_QCOM_BASE_PATH}/msm8916/
    done
}

FILES:${PN} += "/boot/modem_fsg"
FILES:${PN}-split = "${FW_QCOM_BASE_PATH}/msm8916/*.mdt ${FW_QCOM_BASE_PATH}/msm8916/*.b*"

SPLIT_FIRMWARE_PACKAGES = " \
    linux-firmware-qcom-${FW_QCOM_NAME}-modem \
    linux-firmware-qcom-${FW_QCOM_NAME}-modem-split \
    linux-firmware-qcom-${FW_QCOM_NAME}-wifi \
    linux-firmware-qcom-${FW_QCOM_NAME}-wifi-split \
    ${PN}-split \
"
