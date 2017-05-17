SUMMARY = "Tools to create boot images for QCOM SoC"

HOMEPAGE = "https://www.codeaurora.org/cgit/quic/kernel/skales/"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://mkbootimg;beginline=3;endline=29;md5=114b84083e657f3886bfa2c1e5de7deb"

DEPENDS = "python dtc"

SRCREV = "6eac9e943de53c4aaaede3697e9226a47686fe25"
PV = "1.5.0+git${SRCPV}"

SRC_URI = "git://codeaurora.org/quic/kernel/skales"

S = "${WORKDIR}/git"

do_install () {
    install -d ${D}${bindir}/skales
    install -m 0755 ${S}/mkbootimg ${D}${bindir}/skales
    install -m 0755 ${S}/dtbTool ${D}${bindir}/skales
}

BBCLASSEXTEND = "native"
