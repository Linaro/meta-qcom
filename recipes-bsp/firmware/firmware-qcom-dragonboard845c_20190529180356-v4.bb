DESCRIPTION = "QCOM Firmware for DragonBoard 845c"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.qcom.txt;md5=cbbe399f2c983ad51768f4561587f000"

SRC_URI = "https://releases.linaro.org/96boards/dragonboard845c/qualcomm/firmware/RB3_firmware_${PV}.zip;subdir=${BP}"
SRC_URI[md5sum] = "ad69855a1275547b16d94a1b5405ac62"
SRC_URI[sha256sum] = "4289d2f2a7124b104d0274879e702aae9b1e50c42eec3747f8584c6744ef65e3"

FW_QCOM_NAME = "sdm845"

require recipes-bsp/firmware/firmware-qcom.inc

DEPENDS += "pil-squasher-native"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/
    install -d ${D}${FW_QCOM_PATH}

    install -m 0444 ./08-dspso/dspso.bin ${D}${FW_QCOM_PATH}

    install -m 0444 ./17-USB3-201-202-FW/K2026090.mem ${D}${nonarch_base_libdir}/firmware/renesas_usb_fw.mem

    install -m 0444 ./39-jsn/slpi*.jsn  ${D}${FW_QCOM_PATH}

    pil-squasher ${D}${FW_QCOM_PATH}/slpi.mbn \
                 ./30-slpi_split/slpi.mdt

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE.qcom.txt ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}
}

SPLIT_FIRMWARE_PACKAGES = " \
    ${PN}-dspso \
    linux-firmware-qcom-${FW_QCOM_NAME}-sensors \
"
