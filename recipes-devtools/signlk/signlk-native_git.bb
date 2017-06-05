DESCRIPTION = "Tool to sign an LK bootloader"
SECTION = "devel"
LICENSE = "BSD-3-Clause & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8b9255257198f5ad2006cfdf0a1f24c1 \
                    file://signer/ELFIO/COPYING;md5=4f932e9ddd12264ae5e569aae5f08ed3"

DEPENDS = "openssl-native util-linux-native"
SRCREV = "059f3f2768a8bc460fe814e2bb4bc8cc3078c8ba"
PV = "0.0+git${SRCPV}"

inherit native

SRC_URI = "git://git.linaro.org/landing-teams/working/qualcomm/signlk.git;protocol=https \
           file://0001-Remove-build-of-signlk-from-script.patch"

S = "${WORKDIR}/git"

do_compile() {
    oe_runmake -f ${S}/signer/Makefile mfile_path=${S}/signer
}

do_install() {
    install -d ${D}${bindir}/signer
    install -m 0755 ${S}/signer/signlk ${D}${bindir}/signer/
    install -m 0755 ${S}/signlk.sh ${D}${bindir}/signlk
}

