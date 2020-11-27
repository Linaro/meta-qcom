# We want to use modesetting + glamor with mesa freedreno driver
# http://bloggingthemonkey.blogspot.fr/2016/11/a-quick-note-for-usersdistros.html
PACKAGECONFIG_append_qcom = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', ' dri3 xshmfence glamor', '', d)}"
