SUMMARY = "Lava test shell helpers"
SECTION = "test"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV = "dcf554ef9b89c74d028734c74edea1ef5e777d33"
SRC_URI = "git://git.linaro.org/lava/lava-dispatcher.git;branch=release;protocol=https"

PV = "2018.2+${SRCPV}"

S = "${WORKDIR}/git"

do_install() {
        mkdir -p ${D}${bindir}
	for file in $(ls lava_dispatcher/lava_test_shell/lava-*)
	do
		install -m 0755 $file ${D}${bindir}/$(basename $file)
	done
}
