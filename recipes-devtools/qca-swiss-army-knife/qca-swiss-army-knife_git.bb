SUMMARY = "A set of utilities to help QCA driver development."
HOMEPAGE = "https://github.com/qca/qca-swiss-army-knife"
SECTION = "devel"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=884c3f3a874b2a0cfa283c7db0e5d604"

SRCREV = "0c01a2abc3e9855b71f0fbea2c335011104d9ec0"
SRC_URI = " \
	git://github.com/qca/${BPN}.git;branch=master;protocol=https \
"

PV = "0.0+${SRCPV}"
S = "${WORKDIR}/git"

do_install () {
	install -d ${D}/${bindir}
	install -m 0755 tools/scripts/*/* ${D}/${bindir}
}

BBCLASSEXTEND = "native nativesdk"
