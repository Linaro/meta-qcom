SUMMARY = "QDL flasing tool"
HOMEPAGE = "https://github.com/andersson/qdl.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://qdl.c;beginline=1;endline=31;md5=1c7d712d897368d3d3c161e5493efc6a"

DEPENDS = "libxml2"
DEPENDS_append_class-target = " udev "

inherit pkgconfig

SRCREV = "760b3dffb03d2b7dfb82c6eac652a092f51c572d"
SRC_URI = "git://github.com/andersson/${BPN}.git;branch=master;protocol=https \
           file://0001-Makefile-Use-pkg-config-for-libxml2-detection.patch"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

do_install () {
    oe_runmake install DESTDIR=${D} prefix=${prefix}
}

BBCLASSEXTEND = "native nativesdk"
