DESCRIPTION = "QCOM Firmware for Arrow SD 600eval"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://license.txt;md5=c09af6bc68c68f92e6a711634ee5cb14"

SRC_URI = "https://eragon.einfochips.com/pub/media/datasheet/SD_600eval-linux_proprietary_firmware-v${PV}.zip"
SRC_URI[md5sum] = "0903e9f656d3cea005ecc8e26f1243b2"
SRC_URI[sha256sum] = "fdffcb2cedc0d0215ee3dec95ce3683a780d9280960d27200379fbe1b21af979"

COMPATIBLE_MACHINE = "(sd-600eval|dragonboard-600c)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/SD_600eval-linux_proprietary_firmware-v${PV}"

do_compile() {
	:
}

do_install() {
    install -d  ${D}${nonarch_base_libdir}/firmware/
    cp -a * ${D}${nonarch_base_libdir}/firmware/

    install -d ${D}${sysconfdir}/
    install -m 0644 license.txt ${D}${sysconfdir}/
}

FILES_${PN} += "${nonarch_base_libdir}/firmware/*"
INSANE_SKIP_${PN} += "arch"
