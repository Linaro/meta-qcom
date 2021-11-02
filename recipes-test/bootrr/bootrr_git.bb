SUMMARY = "simple low-level testing tool for qcom boards"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=987293312a134ab40eec5f3d446cfaff"

SRCREV = "d2329902b701e0efa345628471d0d275d5a5835a"
SRC_URI = "\
	git://github.com/andersson/bootrr.git;branch=master;protocol=https \
	file://bootrr-auto-switch-to-using-sh.patch \
"

S = "${WORKDIR}/git"

do_install() {
	oe_runmake install 'DESTDIR=${D}'
}
