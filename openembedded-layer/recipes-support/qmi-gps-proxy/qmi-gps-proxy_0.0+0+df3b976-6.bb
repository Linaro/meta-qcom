SUMMARY = "QMI GPS proxy daemon"
HOMEPAGE = "https://git.linaro.org/landing-teams/working/qualcomm/pkg/qmi_loc2.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=f84ce8e3f8d00a43026f8a80e62bca8e"

inherit systemd

SRCREV = "debian/${PV}"
SRC_URI = "git://git.linaro.org/landing-teams/working/qualcomm/pkg/qmi_loc2.git;branch=master;protocol=https"
DEPENDS = "qrtr"

S = "${WORKDIR}/git"

debian_do_patch() {
    cd ${S}
    while read line; do patch -p1 < debian/patches/$line; done < debian/patches/series
}

python do_patch() {
    bb.build.exec_func('debian_do_patch', d)
    bb.build.exec_func('patch_do_patch', d)
}

EXTRA_OEMAKE = "'LDFLAGS=${TARGET_LDFLAGS} -L${STAGING_LIBDIR} -lqrtr'"

do_install () {
    oe_runmake install DESTDIR=${D} prefix=${prefix}

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${S}/debian/qmi-gps-proxy.service ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/debian/gnss-gpsd.service ${D}${systemd_unitdir}/system

    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${S}/debian/gnss-gpsd.udev ${D}${sysconfdir}/udev/rules.d/gnss-gpsd.rules
}

SYSTEMD_PACKAGES = "${PN} gnss-gpsd"
SYSTEMD_SERVICE_${PN} = "qmi-gps-proxy.service"
SYSTEMD_AUTO_ENABLE_${PN} = "disable"

PACKAGES =+ "gnss-gpsd"
FILES_gnss-gpsd = "${sysconfdir}/udev/rules.d/gnss-gpsd.rules ${systemd_unitdir}/system/gnss-gpsd.service"
RDEPENDS_gnss-gpsd += "gpsd qmi-gps-proxy"
SYSTEMD_SERVICE_gnss-gpsd= "gnss-gpsd.service"
SYSTEMD_AUTO_ENABLE_gnss-gpsd = "disable"
