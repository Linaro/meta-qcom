FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI_append = " \
    file://0001-freedreno-clear-last_fence-after-resource-tracking.patch \
"

# Enable freedreno driver
GALLIUMDRIVERS_append_apq8064 = ",freedreno"
GALLIUMDRIVERS_append_apq8016 = ",freedreno"
GALLIUMDRIVERS_append_apq8096 = ",freedreno"
GALLIUMDRIVERS_append_sdm845 = ",freedreno"

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

PACKAGECONFIG_append_sdm845 = " \
    gallium \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xa', '', d)} \
"
