SUMMARY = "Boot regression testing (bootrr) for Qualcomm boards"
SECTION = "test"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV = "ca9605bd7211f20feaa18a7c454906b2fc4a602e"
SRC_URI = "git://git@github.com/andersson/${BPN}.git;branch=master;protocol=https"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

do_install() {
	oe_runmake install DESTDIR=${D} prefix=${prefix}
}
