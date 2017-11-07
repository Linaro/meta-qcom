DESCRIPTION = "QCOM Firmware for DragonBoard 410c"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4d087ee0965cb059f1b2f9429e166f64"

SRC_URI = "http://builds.96boards.org/releases/dragonboard410c/qualcomm/firmware/linux-board-support-package-r${PV}.zip"
SRC_URI[md5sum] = "e1c7e8957b8f37a91cadc18c1aef5c04"
SRC_URI[sha256sum] = "a76405fae85399343bc421b6101ba765d92b3709f2d4ae8afe85dc300cf72c7e"

DEPENDS += "mtools-native"

COMPATIBLE_MACHINE = "(dragonboard-410c)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/linux-board-support-package-r${PV}"

do_compile() {
	:
}

do_install() {
    install -d  ${D}/lib/firmware/
    cp -r ./proprietary-linux/* ${D}/lib/firmware/

    MTOOLS_SKIP_CHECK=1 mcopy -i ./bootloaders-linux/NON-HLOS.bin \
    ::image/modem.* ::image/mba.mbn ::image/wcnss.* ${D}/lib/firmware/

    # Venus firmware have been merged in linux-firmware in a different location than
    # what we've been using for now. Let's add symlinks for now, until we switch to linux-firmware
    install -d ${D}/lib/firmware/qcom/venus-1.8/
    for f in ${D}/lib/firmware/venus.*; do
        f=$(basename $f)
        ln -s /lib/firmware/$f ${D}/lib/firmware/qcom/venus-1.8/$f
    done

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE
}

FILES_${PN} += "/lib/firmware/*"
INSANE_SKIP_${PN} += "arch"
