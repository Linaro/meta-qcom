SUMMARY = "QMI compiler"
HOMEPAGE = "https://github.com/andersson/qmic.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ca25dbf5ebfc1a058bfc657c895aac2f"

SRCREV = "1c036374ea1dd7a831821efbe3ee686e2a1842fe"
SRC_URI = "git://github.com/andersson/${BPN}.git;branch=master;protocol=https \
           file://0001-Makefile-Allow-compiler-linker-flags-to-be-overridde.patch \
          "

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"

do_install () {
    oe_runmake install DESTDIR=${D} prefix=${prefix}
}
