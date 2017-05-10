SUMMARY = "Qualcomm QRTR applications and library"
HOMEPAGE = "https://github.com/andersson/qrtr.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=15329706fbfcb5fc5edcc1bc7c139da5"

inherit systemd

SRCREV = "dee8a384dc6ba02d41caa1f61d0b267c4ba74ff0"
SRC_URI = "git://github.com/andersson/${BPN}.git;branch=master;protocol=https"
SRC_URI += "file://qrtr.service"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "prefix=${prefix} bindir=${bindir} libdir=${libdir} includedir=${includedir} LDFLAGS='${LDFLAGS}'"

do_install () {
    oe_runmake install DESTDIR=${D}

    sed -i -e s:/usr/bin:${bindir}:g ${WORKDIR}/qrtr.service
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/qrtr.service ${D}${systemd_unitdir}/system
}

SYSTEMD_SERVICE_${PN} = "qrtr.service"

PACKAGES =+ "qrtr-apps"
FILES_qrtr-apps = "${bindir}/*"
