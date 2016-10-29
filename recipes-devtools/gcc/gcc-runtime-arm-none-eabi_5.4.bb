require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-runtime.inc
require gcc-arm-none-eabi.inc

RUNTIMETARGET = "libgcc"

DEPENDS = "gcc-cross-arm-none-eabi virtual/libc"
PN = "gcc-runtime-arm-none-eabi"

do_install_append() {
	# Hoist libgcc up into the directory where the compiler will look for it
	mv ${D}${libdir}/gcc/${TARGET_SYS} ${D}${libdir}/
	rmdir ${D}${libdir}/gcc
}

PACKAGES = "${PN}-dev"
FILES_${PN}-dev = "${libdir}/${TARGET_SYS}"
RDEPENDS_${PN}-dev = ""
INSANE_SKIP_${PN}-dev = "staticdev"
