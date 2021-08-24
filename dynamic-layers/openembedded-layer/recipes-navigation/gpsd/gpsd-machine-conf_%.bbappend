FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = " \
           file://gpsd.pds \
"

inherit update-alternatives

ALTERNATIVE:${PN} = "gpsd-defaults"
ALTERNATIVE_LINK_NAME[gpsd-defaults] = "${sysconfdir}/default/gpsd"
ALTERNATIVE_TARGET[gpsd-defaults] = "${sysconfdir}/default/gpsd.pds"
ALTERNATIVE_PRIORITY[gpsd-defaults] = "15"

do_install:append:qcom() {
    install -d ${D}/${sysconfdir}/default
    install -m 0644 ${WORKDIR}/gpsd.pds ${D}/${sysconfdir}/default/
}

FILES:${PN} = "${sysconfdir}"
