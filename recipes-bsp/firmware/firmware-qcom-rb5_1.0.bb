# Provide base URI of NHLOS_Binaries.zip and adreno_1.0_qrb5165_rb5.tar.gz
# files.  Use "file://" if those files are copied into
# recipes-bsp/firmware/files/ directory.
# NHLOS_URI ?= "file://"
# ADRENO_URI ?= "file://"

DESCRIPTION = "QCOM Firmware for Qualcomm Robotics RB5 platform"

LICENSE = "Proprietary"

# There is no license file in the archive
#LIC_FILES_CHKSUM = "file://license.txt;md5="
ERROR_QA_remove = "license-checksum"

NHLOS_ARCHIVE = "NHLOS_Binaries.zip"
ADRENO_ARCHIVE = "adreno_1.0_qrb5165_rb5.tar.gz"

SRC_URI_NHLOS = "${NHLOS_URI}${NHLOS_ARCHIVE}"
SRC_URI_ADRENO = "${ADRENO_URI}${ADRENO_ARCHIVE};unpack=0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# do_unpack is written in Python, so let's use do_compile here
do_compile() {
    if [ -r ${WORKDIR}/${ADRENO_ARCHIVE} ] ; then
        tar xzf ${WORKDIR}/${ADRENO_ARCHIVE} .//lib/firmware
    fi
}

do_install() {
    if [ -n "${ADRENO_URI}" ] ; then
        install -d  ${D}${nonarch_base_libdir}/firmware/qcom
        install -m 0444 ./lib/firmware/a650_*.* ${D}${nonarch_base_libdir}/firmware/qcom
    fi

    if [ -n "${NHLOS_URI}" ] ; then
        cd ${WORKDIR}/NHLOS_Binaries
        install -d  ${D}${nonarch_base_libdir}/firmware/qcom/sm8250
        install -m 0444 adsp.b* adsp.mdt adspr.jsn adspua.jsn ${D}${nonarch_base_libdir}/firmware/qcom/sm8250
        install -m 0444 cdsp.b* cdsp.mdt cdspr.jsn ${D}${nonarch_base_libdir}/firmware/qcom/sm8250
        install -m 0444 slpi.b* slpi.mdt slpir.jsn slpius.jsn ${D}${nonarch_base_libdir}/firmware/qcom/sm8250
        install -m 0444 venus.b* venus.mdt ${D}${nonarch_base_libdir}/firmware/qcom/sm8250

        install -m 0444 verinfo/Ver_Info.txt ${D}${nonarch_base_libdir}/firmware/qcom/sm8250
    fi
}

FILES_${PN} += "${nonarch_base_libdir}/firmware/*"
INSANE_SKIP_${PN} += "arch"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_DEFAULT_DEPS = "1"

# We list firmware-qcom-rb5 in RRECOMMENDS, so we can not skip the recipe here
# If firmware files are not provided, do not download/package anything
python () {
    if d.getVar("NHLOS_URI") == "" and d.getVar("ADRENO_URI") == "":
        bb.warn("Not packaging RB5 firmware. Please update HNLOS_URI and ADRENO_URI")

    uri = d.getVar("NHLOS_URI")
    if uri != None and uri != "":
        d.appendVar("SRC_URI", " ${SRC_URI_NHLOS}")
        d.appendVarFlag('do_unpack', 'depends', ' unzip-native:do_populate_sysroot')

    uri = d.getVar("ADRENO_URI")
    if uri != None and uri != "":
        d.appendVar("SRC_URI", " ${SRC_URI_ADRENO}")
}
