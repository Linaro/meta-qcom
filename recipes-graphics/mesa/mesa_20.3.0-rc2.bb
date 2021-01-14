require recipes-graphics/mesa/mesa.inc

FILESPATH_append := ":${COREBASE}/meta/recipes-graphics/mesa/files"

SRC_URI = "https://mesa.freedesktop.org/archive/mesa-${PV}.tar.xz \
           file://0001-meson.build-check-for-all-linux-host_os-combinations.patch \
           file://0002-meson.build-make-TLS-ELF-optional.patch \
           file://0004-Revert-mesa-Enable-asm-unconditionally-now-that-gen_.patch \
           file://0001-meson-misdetects-64bit-atomics-on-mips-clang.patch \
           file://0001-futex.h-Define-__NR_futex-if-it-does-not-exist.patch \
           file://0001-anv-fix-a-build-race-between-generating-a-header-and.patch \
           "

SRC_URI[sha256sum] = "671bfc98724ca04ccda3255d9aa7fe3c730b10477446983a708305d00e9f5b5b"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'egl', 'true', 'false', d)}; then
        sed -i -e 's/^#elif defined(__unix__) && defined(EGL_NO_X11)$/#elif defined(__unix__) \&\& defined(EGL_NO_X11) || ${@bb.utils.contains('PACKAGECONFIG', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
    fi
}

# Remove extra file added in meta-qcom's bbappend
SRC_URI_remove = " \
	file://0001-freedreno-clear-last_fence-after-resource-tracking.patch \
"

LIC_FILES_CHKSUM = "file://docs/license.rst;md5=9aa1bc48c9826ad9fdb16661f6930496"

PACKAGECONFIG[dri] = "-Ddri-drivers=${DRIDRIVERS}, -Ddri-drivers='', xorgproto libdrm"

# Do not select this version by default
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_sm8250 = ""
