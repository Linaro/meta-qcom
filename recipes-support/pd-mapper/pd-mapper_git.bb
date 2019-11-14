SUMMARY = "Qualcomm pd-mapper application"
HOMEPAGE = "https://github.com/andersson/pd-mapper.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c5d4ab97bca4e843c5afdbf78aa5fdee"

DEPENDS = "qrtr"

inherit systemd

SRCREV = "4236829a625ba5e90e689bc3d07e5ad15bca9733"
SRC_URI = "git://github.com/andersson/${BPN}.git;branch=master;protocol=https"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "prefix=${prefix} bindir=${bindir} libdir=${libdir} includedir=${includedir} LDFLAGS='${LDFLAGS} -Wl,-lqrtr'"

do_install () {
    oe_runmake install DESTDIR=${D} prefix=${prefix} servicedir=${systemd_unitdir}/system
}

SYSTEMD_SERVICE_${PN} = "pd-mapper.service"
RDEPENDS_${PN} += "qrtr"
