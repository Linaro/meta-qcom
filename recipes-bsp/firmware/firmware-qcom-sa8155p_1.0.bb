DESCRIPTION = "QCOM Firmware for SA8155p ADP platform"

# Provide base URI of 'sa8155p_adp_fw.zip' files here.
# Use "file://" if those files are copied into
# 'recipes-bsp/firmware/files/' directory.
# SA8155P_ADP_FW_URI ?= "file://"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.qcom.txt;md5=cbbe399f2c983ad51768f4561587f000"

SA8155P_ADP_FW_NAME = "sa8155p_adp_fw"
SA8155P_ADP_FW_ARCHIVE = "sa8155p_adp_fw.zip"

SRC_URI_FW = "${SA8155P_ADP_FW_URI}${SA8155P_ADP_FW_ARCHIVE}"

require recipes-bsp/firmware/firmware-qcom.inc
DEPENDS += "qca-swiss-army-knife-native"

COMPATIBLE_MACHINE = "(sa8155p)"
S = "${WORKDIR}/${SA8155P_ADP_FW_NAME}"

do_install() {
	cd ${S}
        install -d  ${D}${nonarch_base_libdir}/firmware/
        install -d  ${D}${nonarch_base_libdir}/firmware/qcom/sa8155p

        install -m 0444 adsp*.* ${D}${nonarch_base_libdir}/firmware/qcom/sa8155p
        install -m 0444 cdsp*.* ${D}${nonarch_base_libdir}/firmware/qcom/sa8155p

        install -d ${D}${sysconfdir}/
        install -m 0644 LICENSE.qcom.txt ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}
}

FILES_${PN} += "${nonarch_base_libdir}/firmware/*"
INSANE_SKIP_${PN} += "arch"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_DEFAULT_DEPS = "1"

# We list firmware-qcom-sa8155p in RRECOMMENDS, so we can not skip the recipe here
# If firmware files are not provided, do not download/package anything
python () {
    if d.getVar("SA8155P_ADP_FW_URI") == "":
        bb.warn("Not packaging SA8155p ADP firmware. Please update SA8155P_ADP_FW_URI")

    uri = d.getVar("SA8155P_ADP_FW_URI")
    if uri != None and uri != "":
        d.appendVar("SRC_URI", " ${SRC_URI_FW}")
        d.appendVarFlag('do_unpack', 'depends', ' unzip-native:do_populate_sysroot')
}
