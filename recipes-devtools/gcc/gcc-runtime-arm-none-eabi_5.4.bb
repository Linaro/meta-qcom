require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-runtime.inc
ORIG_TARGET_ARCH := "${TARGET_ARCH}"
ORIG_TUNE_FEATURES := "${TUNE_FEATURES}"
require gcc-arm-none-eabi.inc

# Need to set DPKG_ARCH to match the real target architecture, so
# dpkg can find it (e.g., for SDK construction).
DPKG_ARCH = "${@debian_arch_map(d.getVar('ORIG_TARGET_ARCH', True), d.getVar('ORIG_TUNE_FEATURES', True))}"

RUNTIMETARGET = "libgcc"

DEPENDS = "gcc-cross-arm-none-eabi"
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
