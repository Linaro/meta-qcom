DESCRIPTION = "QCOM Firmware for DragonBoard 845c"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.qcom.txt;md5=cbbe399f2c983ad51768f4561587f000"

SRC_URI = "https://releases.linaro.org/96boards/dragonboard845c/qualcomm/firmware/RB3_firmware_${PV}.zip"
SRC_URI[md5sum] = "8e9489a4bdfd3738ce4683a970b49f42"
SRC_URI[sha256sum] = "d88ad0873792687b2906107b3244da874264c19384e49f2c4aec6768081cd29a"

COMPATIBLE_MACHINE = "(dragonboard-845c)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/RB3_firmware_${PV}"

do_compile() {
	:
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/
    install -d ${D}${nonarch_base_libdir}/firmware/qcom/venus-5.2/

    install -m 0444 ./17-USB3-201-202-FW/K2026090.mem ${D}${nonarch_base_libdir}/firmware/
    install -m 0444 ./18-adreno-fw/a630*.* ${D}${nonarch_base_libdir}/firmware/
    install -m 0444 ./20-adsp_split/firmware/adsp*.* ${D}${nonarch_base_libdir}/firmware/
    install -m 0444 ./21-cdsp_split/firmware/cdsp*.* ${D}${nonarch_base_libdir}/firmware/
    install -m 0444 ./33-venus_split/venus.* ${D}${nonarch_base_libdir}/firmware/qcom/venus-5.2/
    install -m 0444 ./37-wlan_FW/wlanmdsp.mbn ${D}${nonarch_base_libdir}/firmware/
    install -m 0444 ./38-bdwlan_split/bdwlan*.* ${D}${nonarch_base_libdir}/firmware/

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE.qcom.txt ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE
}

FILES_${PN} += "${nonarch_base_libdir}/firmware/*"
INSANE_SKIP_${PN} += "arch"

RPROVIDES_${PN} += "linux-firmware-qcom-adreno-a630"
RREPLACES_${PN} += "linux-firmware-qcom-adreno-a630"
RCONFLICTS_${PN} += "linux-firmware-qcom-adreno-a630"

RPROVIDES_${PN} += "linux-firmware-qcom-venus-5.2"
RREPLACES_${PN} += "linux-firmware-qcom-venus-5.2"
RCONFLICTS_${PN} += "linux-firmware-qcom-venus-5.2"

RPROVIDES_${PN} += "linux-firmware-qcom-license"
RREPLACES_${PN} += "linux-firmware-qcom-license"
RCONFLICTS_${PN} += "linux-firmware-qcom-license"
