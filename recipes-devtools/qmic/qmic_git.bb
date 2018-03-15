SUMMARY = "QMI compiler"
HOMEPAGE = "https://github.com/andersson/qmic.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ca25dbf5ebfc1a058bfc657c895aac2f"

SRCREV = "4ad63502c5ce3f4fbdf223dc7f58d6ba9bbf5eea"
SRC_URI = "git://github.com/andersson/${BPN}.git;branch=master;protocol=https"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"

do_install () {
    oe_runmake install DESTDIR=${D} prefix=${prefix}
}
