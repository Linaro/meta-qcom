# Enable freedreno driver
GALLIUMDRIVERS_append_ifc6410 = ",freedreno"
GALLIUMDRIVERS_append_dragonboard-410c = ",freedreno"

PACKAGECONFIG_append_ifc6410 = " gallium \
                         ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xa', '', d)} \
                       "
PACKAGECONFIG_append_dragonboard-410c = " gallium \
                         ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xa', '', d)} \
                       "
