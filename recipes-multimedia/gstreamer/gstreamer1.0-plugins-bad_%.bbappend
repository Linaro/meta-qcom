PACKAGECONFIG_GL_apq8064 = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2 egl', '', d)}"
PACKAGECONFIG_GL_apq8016 = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2 egl', '', d)}"
PACKAGECONFIG_GL_apq8096 = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2 egl', '', d)}"
