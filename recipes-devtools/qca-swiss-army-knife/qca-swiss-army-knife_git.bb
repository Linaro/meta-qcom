SUMMARY = "A set of utilities to help QCA driver development."
HOMEPAGE = "https://github.com/qca/qca-swiss-army-knife"
SECTION = "devel"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=884c3f3a874b2a0cfa283c7db0e5d604"

SRCREV = "5ede3cc07e9a52f115101c28f833242b772eeaab"
SRC_URI = " \
	git://github.com/qca/${BPN}.git;branch=master;protocol=https \
	file://0001-ath10k-bdencoder-Switch-to-python3.patch \
	file://0002-ath10k-bdencoder-Add-option-to-switch-to-ath11k-mode.patch \
	file://0001-read-powers-port-to-python3.patch \
	file://0002-ath10k-fwencoder-port-to-python3.patch \
	file://0003-scripts-port-to-python3.patch \
	file://ath10k-generate-board-2_json.sh \
	file://ath11k-generate-board-2_json.sh \
"

PV = "0.0+${SRCPV}"
S = "${WORKDIR}/git"

do_install () {
	install -d ${D}/${bindir}
	install -m 0755 tools/scripts/*/* ${D}/${bindir}
	install -m 0755 ${WORKDIR}/ath10k-generate-board-2_json.sh ${D}/${bindir}
	install -m 0755 ${WORKDIR}/ath11k-generate-board-2_json.sh ${D}/${bindir}
}

BBCLASSEXTEND = "native nativesdk"

RDEPENDS_${PN} += "perl python3-core"
