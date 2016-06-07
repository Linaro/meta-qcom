SUMMARY = "RMTFS QMI service"
HOMEPAGE = "https://github.com/andersson/mrtfs.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ca25dbf5ebfc1a058bfc657c895aac2f"

SRCREV = "dc7de6ef564d082cb89e0ac8b7649079ab231263"
SRC_URI = "git://github.com/andersson/${BPN}.git;branch=master;protocol=https"
DEPENDS = "qmic-native qrtr"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "'LDFLAGS=${TARGET_LDFLAGS} -L${STAGING_LIBDIR} -lqrtr'"

do_install () {
    oe_runmake install DESTDIR=${D} prefix=${prefix}
}
