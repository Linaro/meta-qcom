SUMMARY = "A tool to debug Qualcomm clock controllers."
HOMEPAGE = "https://github.com/andersson/debugcc/"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://debugcc.c;beginline=5;endline=29;md5=5598b6b886a3af944e4d19bb7d947095"

SRC_URI = "\
    git://github.com/andersson/debugcc.git;branch=master;protocol=https \
"

SRCREV = "1f2d56984ec60e6ca0a18718c75c4e593542cefc"

PV = "0.0+git${SRCPV}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "CC='${CC}' CPPFLAGS='${CPPFLAGS}' CFLAGS='${CFLAGS}' LDFLAGS='${LDFLAGS}'"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/debugcc ${D}${bindir}
    for f in ${B}/*-debugcc ; do
        ln -r -s -T ${D}${bindir}/debugcc ${D}${bindir}/`basename $f`
    done
}
