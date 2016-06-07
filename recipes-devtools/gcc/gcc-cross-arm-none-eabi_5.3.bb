require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-cross.inc
require gcc-arm-none-eabi.inc

PN = "gcc-cross-arm-none-eabi"
PROVIDES = "${PN}"
DEPENDS = "binutils-cross-arm-none-eabi ${NATIVEDEPS}"

EXTRA_OEMAKE += "inhibit_libc=true"

do_install_append() {
	hardlinkdir . ${D}${includedir}/gcc-build-internal-${TARGET_SYS}
}
