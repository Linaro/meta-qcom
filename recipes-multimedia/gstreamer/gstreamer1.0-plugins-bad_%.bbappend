
# We want OpenGL with freedreno for our machines
PACKAGECONFIG_GL_ifc6410 = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'opengl', '', d)}"
PACKAGECONFIG_GL_dragonboard-410c = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'opengl', '', d)}"
