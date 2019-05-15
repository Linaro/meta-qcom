# Enable freedreno driver
GALLIUMDRIVERS_append_apq8064 = ",freedreno"
GALLIUMDRIVERS_append_apq8016 = ",freedreno"
GALLIUMDRIVERS_append_apq8096 = ",freedreno"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_apq8064 = " file://0001-freedreno-add-query-for-dmabuf-modifiers.patch"
SRC_URI_append_apq8016 = " file://0001-freedreno-add-query-for-dmabuf-modifiers.patch"
SRC_URI_append_apq8096 = " file://0001-freedreno-add-query-for-dmabuf-modifiers.patch"

PACKAGECONFIG_append_apq8064 = " \
    gallium \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xa', '', d)} \
"

PACKAGECONFIG_append_apq8016 = " \
    gallium \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xa', '', d)} \
"

PACKAGECONFIG_append_apq8096 = " \
    gallium \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xa', '', d)} \
"
