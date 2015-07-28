# Enable freedreno driver
GALLIUMDRIVERS_append_ifc6410 = ",freedreno"

PACKAGECONFIG_append_ifc6410 = " gallium \
                         ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xa', '', d)} \
                       "
