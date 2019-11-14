DESCRIPTION = "QCOM Firmware for DragonBoard 845c"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.qcom.txt;md5=cbbe399f2c983ad51768f4561587f000"

SRC_URI = " \
	https://releases.linaro.org/96boards/dragonboard845c/qualcomm/firmware/RB3_firmware_${PV}.zip \
	git://github.com/andersson/linux-firmware.git;branch=db845c-wifi;name=andersson;destsuffix=git \
"
SRC_URI[md5sum] = "ad69855a1275547b16d94a1b5405ac62"
SRC_URI[sha256sum] = "4289d2f2a7124b104d0274879e702aae9b1e50c42eec3747f8584c6744ef65e3"
SRCREV_andersson = "e165604ca024d60652c299539c4602fdfb781e24"

COMPATIBLE_MACHINE = "(dragonboard-845c)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}"

do_compile() {
	:
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/
    install -d ${D}${nonarch_base_libdir}/firmware/ath10k/WCN3390/hw1.0
    install -d ${D}${nonarch_base_libdir}/firmware/qcom/venus-5.2/
    install -d ${D}${nonarch_base_libdir}/firmware/qcom/sdm845

    install -m 0444 ./17-USB3-201-202-FW/K2026090.mem ${D}${nonarch_base_libdir}/firmware/
    install -m 0444 ./18-adreno-fw/a630*.* ${D}${nonarch_base_libdir}/firmware/
    install -m 0444 ./20-adsp_split/firmware/adsp*.* ${D}${nonarch_base_libdir}/firmware/qcom/sdm845
    install -m 0444 ./21-cdsp_split/firmware/cdsp*.* ${D}${nonarch_base_libdir}/firmware/qcom/sdm845
    install -m 0444 ./33-venus_split/venus.* ${D}${nonarch_base_libdir}/firmware/qcom/venus-5.2/
    install -m 0444 ./38-bdwlan_split/bdwlan*.* ${D}${nonarch_base_libdir}/firmware/

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE.qcom.txt ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE

    install -m 0444 ./git/ath10k/WCN3990/hw1.0/board-2.bin ${D}${nonarch_base_libdir}/firmware/ath10k/WCN3390/hw1.0
    install -m 0444 ./git/ath10k/WCN3990/hw1.0/firmware-5.bin ${D}${nonarch_base_libdir}/firmware/ath10k/WCN3390/hw1.0
    install -m 0444 ./git/qcom/sdm845/mba.mbn ${D}${nonarch_base_libdir}/firmware/qcom/sdm845
    install -m 0444 ./git/qcom/sdm845/modem.mbn ${D}${nonarch_base_libdir}/firmware/qcom/sdm845
    install -m 0444 ./git/qcom/sdm845/modemuw.jsn ${D}${nonarch_base_libdir}/firmware/qcom/sdm845
    install -m 0444 ./git/qcom/sdm845/wlanmdsp.mbn ${D}${nonarch_base_libdir}/firmware/qcom/sdm845

}

FILES_${PN} += "${nonarch_base_libdir}/firmware/*"
INSANE_SKIP_${PN} += "arch"

RPROVIDES_${PN} += "linux-firmware-qcom-adreno-a630"
RREPLACES_${PN} += "linux-firmware-qcom-adreno-a630"
RCONFLICTS_${PN} += "linux-firmware-qcom-adreno-a630"

RPROVIDES_${PN} += "linux-firmware-ath10k"
RREPLACES_${PN} += "linux-firmware-ath10k"
RCONFLICTS_${PN} += "linux-firmware-ath10k"

RPROVIDES_${PN} += "linux-firmware-ath10k-license"
RREPLACES_${PN} += "linux-firmware-ath10k-license"
RCONFLICTS_${PN} += "linux-firmware-ath10k-license"

RPROVIDES_${PN} += "linux-firmware-qcom-venus-5.2"
RREPLACES_${PN} += "linux-firmware-qcom-venus-5.2"
RCONFLICTS_${PN} += "linux-firmware-qcom-venus-5.2"

RPROVIDES_${PN} += "linux-firmware-qcom-license"
RREPLACES_${PN} += "linux-firmware-qcom-license"
RCONFLICTS_${PN} += "linux-firmware-qcom-license"

INSANE_SKIP_${PN} += "ldflags"
