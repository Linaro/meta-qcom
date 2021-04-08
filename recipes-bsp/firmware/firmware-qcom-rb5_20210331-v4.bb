# Provide base URI of NHLOS_Binaries.zip and adreno_1.0_qrb5165_rb5.tar.gz
# files.  Use "file://" if those files are copied into
# recipes-bsp/firmware/files/ directory.
# NHLOS_URI ?= "file://"
# ADRENO_URI ?= "file://"

DESCRIPTION = "QCOM Firmware for Qualcomm Robotics RB5 platform"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.qcom.txt;md5=cbbe399f2c983ad51768f4561587f000"

SRC_URI = " \
    http://releases.linaro.org/96boards/rb5/qualcomm/firmware/RB5_firmware_${PV}.zip;subdir=${BP} \
"
SRC_URI[md5sum] = "d65ec09ba18dcafe291c870e0516c290"
SRC_URI[sha256sum] = "30e2c02be32de9f809b590f4fe76d9eb66d35f8c7d13b1f2850beb3d793192cc"

# From v2 to v4 the versioning has changed, so add epoch
# 20210118133815-v2
# 20210331-v4
PE = "1"

DEPENDS += "qca-swiss-army-knife-native"

PACKAGE_ARCH = "${MACHINE_ARCH}"

VENUS_FW = "vpu-1.0"

do_compile() {
    # Build board-2.bin needed by WiFi
    ath11k-generate-board-2_json.sh ./38-bdwlan_split board-2.json
    python3 "${STAGING_BINDIR_NATIVE}/ath10k-bdencoder" -m ath11k -c board-2.json -o board-2.bin
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/qcom/sm8250

    install -m 0444 ./08-dspso/dspso.bin ${D}${nonarch_base_libdir}/firmware/qcom/sm8250

    install -m 0444 ./18-adreno-fw/a650_gmu.bin ${D}${nonarch_base_libdir}/firmware/qcom
    install -m 0444 ./18-adreno-fw/a650_sqe.fw ${D}${nonarch_base_libdir}/firmware/qcom
    install -m 0444 ./18-adreno-fw/a650_zap.elf ${D}${nonarch_base_libdir}/firmware/qcom/sm8250/a650_zap.mbn

    install -m 0444 ./20-adsp_split/adsp.mbn  ${D}${nonarch_base_libdir}/firmware/qcom/sm8250/
    install -m 0444 ./21-cdsp_split/cdsp.mbn  ${D}${nonarch_base_libdir}/firmware/qcom/sm8250/
    install -m 0444 ./30-slpi_split/slpi.mbn  ${D}${nonarch_base_libdir}/firmware/qcom/sm8250/

    install -m 0444 ./39-jsn/*.jsn  ${D}${nonarch_base_libdir}/firmware/qcom/sm8250/

    install -d ${D}${nonarch_base_libdir}/firmware/qcom/${VENUS_FW}
    install -m 0444 ./33-venus_split/venus.b* ./33-venus_split/venus.mdt ${D}${nonarch_base_libdir}/firmware/qcom/${VENUS_FW}

    install -d ${D}${nonarch_base_libdir}/firmware/ath11k/QCA6390/hw2.0/
    install -m 0444 ${S}/board-2.bin ${D}${nonarch_base_libdir}/firmware/ath11k/QCA6390/hw2.0/board-2.bin

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE.qcom.txt ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}
}

FILES_${PN} += "${nonarch_base_libdir}/firmware/"
INSANE_SKIP_${PN} += "arch"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_DEFAULT_DEPS = "1"

RPROVIDES_${PN} += "linux-firmware-qcom-adreno-a650"
RREPLACES_${PN} += "linux-firmware-qcom-adreno-a650"
RCONFLICTS_${PN} += "linux-firmware-qcom-adreno-a650"

RPROVIDES_${PN} += "linux-firmware-qcom-${VENUS_FW}"
RREPLACES_${PN} += "linux-firmware-qcom-${VENUS_FW}"
RCONFLICTS_${PN} += "linux-firmware-qcom-${VENUS_FW}"

inherit update-alternatives

ALTERNATIVE_${PN} = "qca6390-board2"
ALTERNATIVE_LINK_NAME[qca6390-board2] = "/lib/firmware/ath11k/QCA6390/hw2.0/board-2.bin"
ALTERNATIVE_PRIORITY = "100"
