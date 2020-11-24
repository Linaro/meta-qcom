require recipes-graphics/mesa/mesa.inc

FILESEXTRAPATHS_prepend := "${COREBASE}/meta/recipes-graphics/mesa/files:"

SRC_URI[sha256sum] = "671bfc98724ca04ccda3255d9aa7fe3c730b10477446983a708305d00e9f5b5b"

SRC_URI_remove = " \
	file://0001-meson-Add-xcb-fixes-to-loader-when-using-x11-and-dri.patch \
	file://0005-vc4-use-intmax_t-for-formatted-output-of-timespec-me.patch \
"

# Do not select this version by default
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_sm8250 = "1"
