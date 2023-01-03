SUMMARY = "A tool to debug Qualcomm clock controllers."
HOMEPAGE = "https://github.com/andersson/debugcc/"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://debugcc.c;beginline=5;endline=29;md5=5598b6b886a3af944e4d19bb7d947095"

SRC_URI = "\
    git://github.com/andersson/debugcc.git;branch=master;protocol=https \
\
    file://block/0001-debugcc-add-support-for-printing-clocks-from-a-singl.patch \
    file://block/0002-debugcc-add-block-names-to-all-platforms.patch \
\
    file://msm8996/0001-debugcc-preserve-xo_div4-contents.patch \
    file://msm8996/0002-msm8996-add-support-for-MSM8996-platform.patch \
    file://msm8996/0003-debugcc-allow-customizing-the-measurement-process.patch \
    file://msm8996/0004-msm8996-add-support-for-CPU-clocks.patch \
\
    file://0001-msm8996-add-block-names.patch \
    file://0001-Add-DEBUGCC-entries-for-SM8550.patch \
"

SRCREV = "79d8caba44135b7470dddaee3cfb93bd73b89c5e"

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
