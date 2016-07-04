SUMMARY = "WLAN and BT configuration files for QCOM WCN"
HOMEPAGE = "https://git.linaro.org/landing-teams/working/qualcomm/wcnss-config.git"
SECTION = "devel"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=9ffc7d99f148b53a339cd4374c5c431f"

SRCREV = "debian/${PV}"
SRC_URI = "git://git.linaro.org/landing-teams/working/qualcomm/wcnss-config.git;branch=master;protocol=https"

S = "${WORKDIR}/git"

inherit systemd allarch

PACKAGES =+ "wcnss-start"

do_install () {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0755 ${S}/debian/wcnss-wlan.udev ${D}${sysconfdir}/udev/rules.d/wcnss-wlan.rules

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/debian/wcnss-wlan.service ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/debian/wcnss-start.service ${D}${systemd_unitdir}/system

    install -d ${D}${sbindir}
    install -m 0755 ${S}/wcnss-gen-macaddr ${D}${sbindir}
    install -m 0755 ${S}/wcnss-start ${D}${sbindir}
}

FILES_wcnss-start = "${sbindir}/wcnss-start ${systemd_unitdir}/system/wcnss-start.service"

# need wcnss-gen-macaddr
RDEPENDS_wcnss-start += "${PN}"

SYSTEMD_PACKAGES = "${PN} wcnss-start"
SYSTEMD_SERVICE_${PN} = "wcnss-wlan.service"
SYSTEMD_AUTO_ENABLE_${PN} = "disable"
SYSTEMD_SERVICE_wcnss-start = "wcnss-start.service"
