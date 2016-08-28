require recipes-devtools/binutils/binutils.inc
require recipes-devtools/binutils/binutils-${PV}.inc

inherit cross-canadian

SUMMARY = "GNU binary utilities (cross-canadian for arm-none-eabi target)"
PN = "binutils-cross-canadian-arm-none-eabi"
BPN = "binutils"

REAL_TARGET_VENDOR := "${TARGET_VENDOR}"
REAL_TARGET_OS := "${TARGET_OS}"
DEPENDS = "flex-native bison-native virtual/${HOST_PREFIX}gcc-crosssdk virtual/nativesdk-libc nativesdk-zlib nativesdk-gettext nativesdk-flex"
EXTRA_OECONF += "--with-sysroot=${SDKPATH}/sysroots/${TUNE_PKGARCH}${REAL_TARGET_VENDOR}-${REAL_TARGET_OS} \
                "

FILESEXTRAPATHS_prepend := "${COREBASE}/meta/recipes-devtools/binutils/binutils:"

PROVIDES = ""
TARGET_ARCH = "arm"
TARGET_VENDOR = "-none"
TARGET_VENDOR_virtclass-multilib-lib32 = "-none"
TARGET_OS = "eabi"
MODIFYTOS = "0"

# We have to point binutils at a sysroot but we don't need to rebuild if this changes
# e.g. we switch between different machines with different tunes.
EXTRA_OECONF[vardepsexclude] = "TUNE_PKGARCH"

do_install () {
	autotools_do_install

	# We're not interested in the libs or headers, these would come from the
	# nativesdk or target version of the binutils recipe
	rm -rf ${D}${prefix}/${TARGET_SYS}
	rm -f ${D}${libdir}/libbfd*
	rm -f ${D}${libdir}/libiberty*
	rm -f ${D}${libdir}/libopcodes*
	rm -f ${D}${includedir}/*.h

	cross_canadian_bindirlinks

}

BBCLASSEXTEND = ""
