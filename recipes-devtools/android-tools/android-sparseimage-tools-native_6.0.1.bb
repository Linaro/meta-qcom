SUMMARY = "Android host-side tools (subset for sparse image manipulation only)"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://extras/ext4_utils/NOTICE;md5=bb2810bf31da2f6bb39e0bfa86091da3 \
                    file://core/NOTICE;md5=c1a3ff0b97f199c7ebcfdd4d3fed238e"

PR = "r46"
SRC_URI = "git://android.googlesource.com/platform/system/extras;protocol=https;branch=${SRCBRANCH};destsuffix=extras;name=extras \
           git://android.googlesource.com/platform/system/core;protocol=https;branch=${SRCBRANCH};destsuffix=core;name=core \
           file://Makefile \
           file://omit-selinux.patch \
"

SRCBRANCH = "marshmallow-mr2-release"
SRCREV_extras = "android-${PV}_${PR}"
SRCREV_core = "android-${PV}_${PR}"

inherit native

DEPENDS = "zlib-native"

S = "${WORKDIR}"
B = "${WORKDIR}/build"

do_configure() {
    :
}

do_compile() {
    oe_runmake -f ${S}/Makefile srcdir=${S} all
}

do_install() {
    oe_runmake -f ${S}/Makefile srcdir=${S} DESTDIR=${D} install
}
