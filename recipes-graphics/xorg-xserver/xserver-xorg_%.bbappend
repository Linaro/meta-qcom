# We want to use modesetting + glamor with mesa freedreno driver
# http://bloggingthemonkey.blogspot.fr/2016/11/a-quick-note-for-usersdistros.html
PACKAGECONFIG_append_apq8064 = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', ' dri3 xshmfence glamor', '', d)}"
PACKAGECONFIG_append_apq8016 = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', ' dri3 xshmfence glamor', '', d)}"
PACKAGECONFIG_append_apq8096 = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', ' dri3 xshmfence glamor', '', d)}"
PACKAGECONFIG_append_sdm845 = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', ' dri3 xshmfence glamor', '', d)}"
