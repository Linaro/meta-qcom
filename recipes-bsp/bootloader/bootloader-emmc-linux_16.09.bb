DESCRIPTION = "Qualcomm primary bootloader binary blobs for Dragonboard"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://license.txt;md5=c09af6bc68c68f92e6a711634ee5cb14"

SRC_URI = "http://builds.96boards.org/releases/dragonboard410c/linaro/rescue/${PV}/dragonboard410c_bootloader_emmc_linux-72.zip \
	   file://emmc-partitions.txt"
SRC_URI[md5sum] = "0a8281313bf3f813145cd7c60f616e2b"
SRC_URI[sha256sum] = "67bfa09962aacd2b631bbbb23259b44ef46b3f3339e4d26fe951f270a7fabdc4"

COMPATIBLE_MACHINE = "(apq8016)"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}"
B = "${S}"

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = ""

do_configure() {
    :
}
do_compile() {
    :
}
do_install() {
    install -d ${D}${libdir}/${PN}
    for f in NON-HLOS.bin hyp.mbn rpm.mbn tz-psci.mbn sbl1.mbn license.txt; do
	install -m 0644 $f ${D}${libdir}/${PN}/
    done
    install -m 0644 emmc-partitions.txt ${D}${libdir}/${PN}/partitions.txt
}

PACKAGES = "${PN}-dev ${PN}"
FILES_${PN}-dev = "${libdir}/${PN}"
INSANE_SKIP_${PN}-dev = "arch"
ALLOW_EMPTY_${PN} = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_SYSROOT_STRIP = "1"
