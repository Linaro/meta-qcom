SUMMARY = "simple low-level testing tool for qcom boards"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=987293312a134ab40eec5f3d446cfaff"

SRCREV = "bd84c8a164e9c603db85781cfa019b516a6d2ded"
SRC_URI = "\
	git://github.com/andersson/bootrr.git;branch=master;protocol=https \
"

S = "${WORKDIR}/git"

PV = "0.0+git${SRCPV}"

inherit allarch

do_install() {
	oe_runmake install 'DESTDIR=${D}'
}
