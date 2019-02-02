SUMMARY = "WLAN and BT configuration files for QCOM WCN"
HOMEPAGE = "https://git.linaro.org/landing-teams/working/qualcomm/wcnss-config.git"
SECTION = "devel"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=9ffc7d99f148b53a339cd4374c5c431f"

# TAG:debian/1.13
SRCREV = "655a59f30915bed785d39cc90130dc06b44d7f6f"
SRC_URI = "git://git.linaro.org/landing-teams/working/qualcomm/wcnss-config.git;branch=master;protocol=https"

S = "${WORKDIR}/git"

inherit systemd allarch

PACKAGES =+ "wcnss-start"

do_install () {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/debian/wcnss-start.service ${D}${systemd_unitdir}/system

    install -d ${D}${sbindir}
    install -m 0755 ${S}/wcnss-start ${D}${sbindir}
}

# They are empty, and would break dev-pkgs image feature.
PACKAGES_remove = "${PN}-dev ${PN}-staticdev"

FILES_wcnss-start = "${sbindir}/wcnss-start ${systemd_unitdir}/system/wcnss-start.service"

SYSTEMD_PACKAGES = "wcnss-start"
SYSTEMD_SERVICE_wcnss-start = "wcnss-start.service"
