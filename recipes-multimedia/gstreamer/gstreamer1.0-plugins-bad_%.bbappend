GST_BAD_OPENGL_FEATURES= "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'gles2', 'opengl', d)}"

# We want OpenGL with freedreno for our machines
PACKAGECONFIG_GL_ifc6410 = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '${GST_BAD_OPENGL_FEATURES}', '', d)}"
PACKAGECONFIG_GL_dragonboard-410c = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '${GST_BAD_OPENGL_FEATURES}', '', d)}"
