SUMMARY = "Firmware files for Qualcomm/Atheros WCN6855 SoC"

LICENSE = "Firmware-qualcommAthos_ath10k"
LIC_FILES_CHKSUM = "file://LICENSE.QualcommAtheros_ath10k;md5=cb42b686ee5f5cb890275e4321db60a8"
NO_GENERIC_LICENSE[Firmware-qualcommAthos_ath10k] = "LICENSE.QualcommAtheros_ath10k"

SRC_URI = "git://chromium.googlesource.com/chromiumos/third_party/linux-firmware;protocol=https;branch=master"
SRCREV = "d233ddd89abe06448070471963a58c0a7da81d79"

PV = "1.1-01720.1+git${SRCPV}"

S = "${WORKDIR}/git"

inherit allarch

CLEANBROKEN = "1"

do_compile() {
	:
}

FWDIR = "${nonarch_base_libdir}/firmware/ath11k/WCN6855/hw2.0"
FWDIR21 = "${nonarch_base_libdir}/firmware/ath11k/WCN6855/hw2.1"

do_install() {
    install -d ${D}${FWDIR}

    install -m 0644 ath11k/WCN6855/hw2.0/* ${D}${FWDIR}

    install -d ${D}${FWDIR21}
    ln -sr ${D}${FWDIR}/board.bin ${D}${FWDIR21}/
}

inherit update-alternatives

ALTERNATIVE:${PN} += "wcn6855-hw20-amss wcn6855-hw20-m3 wcn6855-hw20-regdb"
ALTERNATIVE_LINK_NAME[wcn6855-hw20-amss] = "${nonarch_base_libdir}/firmware/ath11k/WCN6855/hw2.0/amss.bin"
ALTERNATIVE_LINK_NAME[wcn6855-hw20-m3] = "${nonarch_base_libdir}/firmware/ath11k/WCN6855/hw2.0/m3.bin"
ALTERNATIVE_LINK_NAME[wcn6855-hw20-regdb] = "${nonarch_base_libdir}/firmware/ath11k/WCN6855/hw2.0/regdb.bin"
ALTERNATIVE_PRIORITY = "100"

PACKAGE_BEFORE_PN = "${PN}-board"

RDEPENDS:${PN}-board += "${PN}"
RDEPENDS:${PN} += "linux-firmware-ath10k-license"

FILES:${PN} = "${FWDIR}"
FILES:${PN}-board = "${FWDIR}/board*.bin ${FWDIR21}/board*.bin"

# Firmware files are generally not ran on the CPU, so they can be
# allarch despite being architecture specific
INSANE_SKIP = "arch"
