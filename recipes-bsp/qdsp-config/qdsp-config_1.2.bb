SUMMARY = "Configuration files for Hexagon DSP on QCOM SoC"
HOMEPAGE = "https://git.linaro.org/landing-teams/working/qualcomm/pkg/qdsp-config.git"
SECTION = "devel"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=0cac98b620cedbb3464bea2237db5bd6"

SRCREV = "debian/${PV}"
SRC_URI = "git://git.linaro.org/landing-teams/working/qualcomm/pkg/qdsp-config.git;branch=master;protocol=https"

S = "${WORKDIR}/git"

inherit systemd allarch

do_install () {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/debian/qdsp-start.service ${D}${systemd_unitdir}/system

    install -d ${D}${sbindir}
    install -m 0755 ${S}/qdsp-start ${D}${sbindir}
}

RDEPENDS_${PN} += "rmtfs"

SYSTEMD_SERVICE_${PN} = "qdsp-start.service"
