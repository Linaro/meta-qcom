inherit allarch

FILES:${PN} += "${nonarch_base_libdir}/firmware/"

INSANE_SKIP:${PN} += "arch already-stripped"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_DEFAULT_DEPS = "1"
