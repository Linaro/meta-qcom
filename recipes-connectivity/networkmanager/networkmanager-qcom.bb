SUMMARY = "Network Manager Ethernet MAC address configuration"

SRC_URI = " \
    file://eth-mac-addr.conf \
    file://COPYING \
"

S = "${WORKDIR}"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=8b392b2a392ec74791be385beaed2012"

do_install () {
    install -d ${D}/${libdir}/NetworkManager/conf.d
    install -m 0644 ${WORKDIR}/eth-mac-addr.conf ${D}/${libdir}/NetworkManager/conf.d/eth-mac-addr.conf
}

FILES_${PN} = "${libdir}/NetworkManager/conf.d"
