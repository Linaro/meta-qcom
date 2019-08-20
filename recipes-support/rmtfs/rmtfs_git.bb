SUMMARY = "RMTFS QMI service"
HOMEPAGE = "https://github.com/andersson/mrtfs.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ca25dbf5ebfc1a058bfc657c895aac2f"

inherit systemd

SRCREV = "df6c19d0330d251af0a7c812bf5ddb847962ce2c"
SRC_URI = "git://github.com/andersson/${BPN}.git;branch=master;protocol=https"
DEPENDS = "qmic-native qrtr udev"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "'LDFLAGS=${TARGET_LDFLAGS} -L${STAGING_LIBDIR} -lqrtr -ludev -lpthread'"

do_install () {
    oe_runmake install DESTDIR=${D} prefix=${prefix} servicedir=${systemd_unitdir}/system
}

SYSTEMD_SERVICE_${PN} = "rmtfs.service"
RDEPENDS_${PN} += "qrtr"
