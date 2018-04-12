DESCRIPTION = "Qualcomm primary bootloader binary blobs for Dragonboard"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4d087ee0965cb059f1b2f9429e166f64"

SRC_URI = "http://builds.96boards.org/releases/dragonboard410c/linaro/rescue/${PV}/dragonboard410c_bootloader_emmc_linux-88.zip \
	   file://emmc-partitions.txt"
SRC_URI[md5sum] = "ac646bc6f18408f84af09672a41e2714"
SRC_URI[sha256sum] = "7337c403a1e9b85592f662180a3a4caacc68f0a945cdb30de3394d148bb66cf5"

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
    for f in sbc_1.0_8016.bin hyp.mbn rpm.mbn tz.mbn sbl1.mbn LICENSE; do
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
