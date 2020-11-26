FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

# Enable freedreno driver
PACKAGECONFIG_FREEDRENO = "\
    freedreno \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xa', '', d)} \
"

PACKAGECONFIG_append_qcom = "${PACKAGECONFIG_FREEDRENO}"
