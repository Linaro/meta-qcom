SUMMARY = "MDT to MBN conversion tool"
HOMEPAGE = "https://github.com/andersson/pil-squasher.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://pil-squasher.c;beginline=1;endline=30;md5=632a4253d26470c9301255e9a3dc31a0"

SRCREV = "843950ff8445cb02ee543ec751ab42112d39a8e0"
SRC_URI = " \
	git://github.com/andersson/${BPN}.git;branch=master;protocol=https \
"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

do_install () {
    oe_runmake install DESTDIR=${D} prefix=${prefix}
}

BBCLASSEXTEND = "native nativesdk"
