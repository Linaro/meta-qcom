SUMMARY = "Qualcomm tqftpserv application"
HOMEPAGE = "https://github.com/andersson/tqftpserv.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=424e013ed97b36284f3b9ce27bb16a56"

DEPENDS = "qrtr"

inherit systemd

SRCREV = "fe53d2a810abe0e1ee7cc0bb20fd520dc6605ecb"
SRC_URI = "git://github.com/andersson/${BPN}.git;branch=master;protocol=https \
           file://0001-include-limits.h-for-PATH_MAX.patch \
"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "prefix=${prefix} bindir=${bindir} libdir=${libdir} includedir=${includedir} LDFLAGS='${LDFLAGS} -Wl,-lqrtr'"

do_install () {
    oe_runmake install DESTDIR=${D} prefix=${prefix} servicedir=${systemd_unitdir}/system
}

SYSTEMD_SERVICE_${PN} = "tqftpserv.service"
RDEPENDS_${PN} += "qrtr"
