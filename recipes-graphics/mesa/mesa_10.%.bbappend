# Enable freedreno driver
GALLIUMDRIVERS_append = ",freedreno"

PACKAGECONFIG_append = " gallium gallium-egl \
                         ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xa', '', d)} \
                       "
