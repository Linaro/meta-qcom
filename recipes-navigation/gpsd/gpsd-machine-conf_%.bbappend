EXTRA_DEPS = ""
EXTRA_DEPS_dragonboard-410c = "qrtr-apps gnss-gpsd qdsp-config"

RDEPENDS_${PN} += "${EXTRA_DEPS}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

ALLOW_EMPTY_${PN} = "1"
