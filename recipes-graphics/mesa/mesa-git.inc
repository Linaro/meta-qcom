SRC_URI = "git://gitlab.freedesktop.org/mesa/mesa.git;protocol=https \
           file://0001-meson.build-check-for-all-linux-host_os-combinations.patch \
           file://0002-meson.build-make-TLS-ELF-optional.patch \
           file://0003-Allow-enable-DRI-without-DRI-drivers.patch \
           file://0004-Revert-mesa-Enable-asm-unconditionally-now-that-gen_.patch \
           file://0005-vc4-use-intmax_t-for-formatted-output-of-timespec-me.patch \
           file://0001-meson-misdetects-64bit-atomics-on-mips-clang.patch \
           file://fix-meson-config-compat.patch \
           "

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM = "file://docs/license.rst;md5=9aa1bc48c9826ad9fdb16661f6930496"

PV = "20.2-pre+git${SRCPV}"

# Do not select this version by default
DEFAULT_PREFERENCE = "-1"
