DESCRIPTION = "QCOM Firmware for DragonBoard 410c"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4d087ee0965cb059f1b2f9429e166f64"

SRC_URI = "http://releases.linaro.org/96boards/dragonboard410c/qualcomm/firmware/linux-board-support-package-r${PV}.zip"
SRC_URI[md5sum] = "25c241bfd5fb2e55e8185752d5fe92ce"
SRC_URI[sha256sum] = "46953b974c5c58c7ca66db414437c0268b033ac9d28127e98d9c4e1a49359da5"

DEPENDS += "mtools-native"

COMPATIBLE_MACHINE = "(dragonboard-410c)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/linux-board-support-package-r${PV}"

do_compile() {
	:
}

do_install() {
    install -d  ${D}${nonarch_base_libdir}/firmware/
    install -d  ${D}/boot
    cp -r ./proprietary-linux/* ${D}${nonarch_base_libdir}/firmware/
    cp ./efs-seed/fs_image_linux.tar.gz.mbn.img ${D}/boot/modem_fsg

    install -d  ${D}${nonarch_base_libdir}/firmware/qcom/msm8916
    MTOOLS_SKIP_CHECK=1 mcopy -i ./bootloaders-linux/NON-HLOS.bin \
    ::image/modem.* ::image/mba.mbn ::image/wcnss.* ${D}${nonarch_base_libdir}/firmware/qcom/msm8916

    # Venus firmware have been merged in linux-firmware in a different location than
    # what we've been using for now. Let's add symlinks for now, until we switch to linux-firmware
    install -d ${D}${nonarch_base_libdir}/firmware/qcom/venus-1.8/
    for f in ${D}${nonarch_base_libdir}/firmware/venus.*; do
        f=$(basename $f)
        ln -s ${nonarch_base_libdir}/firmware/$f ${D}${nonarch_base_libdir}/firmware/qcom/venus-1.8/$f
    done

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE
}

FILES_${PN} += "${nonarch_base_libdir}/firmware/*"
FILES_${PN} += "/boot/modem_fsg"
INSANE_SKIP_${PN} += "arch"

RPROVIDES_${PN} += "linux-firmware-qcom-adreno-a3xx"
RREPLACES_${PN} += "linux-firmware-qcom-adreno-a3xx"
RCONFLICTS_${PN} += "linux-firmware-qcom-adreno-a3xx"

RPROVIDES_${PN} += "linux-firmware-qcom-venus-1.8"
RREPLACES_${PN} += "linux-firmware-qcom-venus-1.8"
RCONFLICTS_${PN} += "linux-firmware-qcom-venus-1.8"

RPROVIDES_${PN} += "linux-firmware-qcom-license"
RREPLACES_${PN} += "linux-firmware-qcom-license"
RCONFLICTS_${PN} += "linux-firmware-qcom-license"
