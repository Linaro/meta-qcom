# Enable freedreno driver ( arm only )
GALLIUMDRIVERS_append_armv7a = ",freedreno"

PACKAGECONFIG_append_armv7a = " gallium gallium-egl \
                         ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xa', '', d)} \
                       "
