require recipes-graphics/mesa/mesa.inc

SRC_URI = "git://gitlab.freedesktop.org/mesa/mesa.git;protocol=https \
           file://0001-meson.build-check-for-all-linux-host_os-combinations.patch \
           file://0002-meson.build-make-TLS-ELF-optional.patch \
           file://0003-Allow-enable-DRI-without-DRI-drivers.patch \
           file://0004-Revert-mesa-Enable-asm-unconditionally-now-that-gen_.patch \
           file://0005-vc4-use-intmax_t-for-formatted-output-of-timespec-me.patch \
           file://0001-meson-misdetects-64bit-atomics-on-mips-clang.patch \
           file://fix-meson-config-compat.patch \
           "
LIC_FILES_CHKSUM = "file://docs/license.rst;md5=9aa1bc48c9826ad9fdb16661f6930496"

SRCREV = "61b714a42ee676fe03b383c0caf050169e404c7d"
#SRCREV_sm8250 = "${AUTOREV}"

S = "${WORKDIR}/git"
PV = "20.3-dev+git${SRCPV}"

# Do not select this version by default
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_sm8250 = "1"
