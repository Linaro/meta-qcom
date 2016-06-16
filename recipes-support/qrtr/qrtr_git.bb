SUMMARY = "Qualcomm QRTR applications and library"
HOMEPAGE = "https://github.com/andersson/qrtr.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=15329706fbfcb5fc5edcc1bc7c139da5"

inherit systemd

SRCREV = "56074bd5fe8f487b3a681b73e669cdbfe3b7b555"
SRC_URI = "git://github.com/andersson/${BPN}.git;branch=master;protocol=https"
SRC_URI += "file://qrtr.service"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

do_install () {
    oe_runmake install DESTDIR=${D} prefix=${prefix}

    sed -i -e s:/usr/bin:${bindir}:g ${WORKDIR}/qrtr.service
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/qrtr.service ${D}${systemd_unitdir}/system
}

SYSTEMD_SERVICE_${PN} = "qrtr.service"

PACKAGES =+ "qrtr-apps"
FILES_qrtr-apps = "${bindir}/*"
