# Enable freedreno driver
GALLIUMDRIVERS_append_apq8064 = ",freedreno"
GALLIUMDRIVERS_append_apq8016 = ",freedreno"
GALLIUMDRIVERS_append_apq8096 = ",freedreno"

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
