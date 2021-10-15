DESCRIPTION = "QCOM Firmware for DragonBoard 410c"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4d087ee0965cb059f1b2f9429e166f64"

DEPENDS += "mtools-native pil-squasher-native"

FW_QCOM_NAME = "msm8916"

require recipes-bsp/firmware/firmware-qcom.inc

S = "${WORKDIR}/linux-board-support-package-r${PV}"

do_install() {
    install -d  ${D}${nonarch_base_libdir}/firmware/

    install -d  ${D}/boot
    cp ./efs-seed/fs_image_linux.tar.gz.mbn.img ${D}/boot/modem_fsg

    cp -r ./proprietary-linux/wlan ${D}${nonarch_base_libdir}/firmware/

    install -d  ${D}${nonarch_base_libdir}/firmware/qcom/msm8916
    MTOOLS_SKIP_CHECK=1 mcopy -i ./bootloaders-linux/NON-HLOS.bin \
    ::image/modem.* ::image/mba.mbn ::image/wcnss.* ${D}${nonarch_base_libdir}/firmware/qcom/msm8916

    pil-squasher ${D}${nonarch_base_libdir}/firmware/qcom/msm8916/modem.mbn \
                 ${D}${nonarch_base_libdir}/firmware/qcom/msm8916/modem.mdt

    pil-squasher ${D}${nonarch_base_libdir}/firmware/qcom/msm8916/wcnss.mbn \
                 ${D}${nonarch_base_libdir}/firmware/qcom/msm8916/wcnss.mdt

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}
}

FILES:${PN} += "/boot/modem_fsg"

SPLIT_FIRMWARE_PACKAGES = " \
    linux-firmware-qcom-${FW_QCOM_NAME}-modem \
    linux-firmware-qcom-${FW_QCOM_NAME}-modem-split \
    linux-firmware-qcom-${FW_QCOM_NAME}-wifi \
    linux-firmware-qcom-${FW_QCOM_NAME}-wifi-split \
"
