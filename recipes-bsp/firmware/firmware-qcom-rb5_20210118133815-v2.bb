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
SRC_URI[md5sum] = "d9289f59fe4f93ce433707294c9286ca"
SRC_URI[sha256sum] = "9d7b42916d83c8f721258175b8d7a9ed758ebe02228d36099e6ea1a2b2a556d3"

PACKAGE_ARCH = "${MACHINE_ARCH}"

VENUS_FW = "vpu-1.0"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/qcom/sm8250

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
    install -m 0444 ./38-bdwlan_split/bdwlan.e04 ${D}${nonarch_base_libdir}/firmware/ath11k/QCA6390/hw2.0/board.bin

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
