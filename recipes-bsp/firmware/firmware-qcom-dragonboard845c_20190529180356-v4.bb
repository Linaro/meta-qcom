DESCRIPTION = "QCOM Firmware for DragonBoard 845c"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.qcom.txt;md5=cbbe399f2c983ad51768f4561587f000"

SRC_URI = "https://releases.linaro.org/96boards/dragonboard845c/qualcomm/firmware/RB3_firmware_${PV}.zip \
           file://generate_board-2_json.sh"
SRC_URI[md5sum] = "ad69855a1275547b16d94a1b5405ac62"
SRC_URI[sha256sum] = "4289d2f2a7124b104d0274879e702aae9b1e50c42eec3747f8584c6744ef65e3"

PACKAGE_ARCH = "${MACHINE_ARCH}"
DEPENDS += "bash-native qca-swiss-army-knife-native"
inherit python3native

S = "${WORKDIR}"

do_compile() {
    # Build board-2.bin needed by WiFi
    mkdir -p bdf
    cp ./38-bdwlan_split/bdwlan*.* bdf
    bash generate_board-2_json.sh bdf board-2.json
    python3 "${STAGING_BINDIR_NATIVE}/ath10k-bdencoder" -c board-2.json -o board-2.bin
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/
    install -d ${D}${nonarch_base_libdir}/firmware/qcom/sdm845

    install -m 0444 ./17-USB3-201-202-FW/K2026090.mem ${D}${nonarch_base_libdir}/firmware/renesas_usb_fw.mem
    install -m 0444 ./18-adreno-fw/a630_zap*.* ${D}${nonarch_base_libdir}/firmware/qcom/
    install -m 0444 ./20-adsp_split/firmware/adsp*.* ${D}${nonarch_base_libdir}/firmware/qcom/sdm845
    install -m 0444 ./21-cdsp_split/firmware/cdsp*.* ${D}${nonarch_base_libdir}/firmware/qcom/sdm845

    install -d ${D}${nonarch_base_libdir}/firmware/ath10k/WCN3990/hw1.0/
    install -m 0444 ./board-2.bin ${D}${nonarch_base_libdir}/firmware/ath10k/WCN3990/hw1.0/

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE.qcom.txt ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}
}

FILES_${PN} += "${nonarch_base_libdir}/firmware/*"
INSANE_SKIP_${PN} += "arch"
