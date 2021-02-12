SUMMARY = "Upgrade Lontium LT9611UXC firmware to the latest image"

SRC_URI = "file://lt9611uxc.service file://lt9611uxc-upgrade.sh"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

RDEPENDS_${PN} += "linux-firmware-lt9611uxc"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/lt9611uxc-upgrade.sh ${D}${bindir}
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/lt9611uxc.service ${D}${systemd_system_unitdir}
}

SYSTEMD_SERVICE_${PN} = "lt9611uxc.service"
