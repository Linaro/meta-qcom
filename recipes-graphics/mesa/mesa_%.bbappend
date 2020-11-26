FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI_append = " \
    file://0001-freedreno-clear-last_fence-after-resource-tracking.patch \
"

# Enable freedreno driver
PACKAGECONFIG_FREEDRENO = "\
    freedreno \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xa', '', d)} \
"

PACKAGECONFIG_append_qcom = "${PACKAGECONFIG_FREEDRENO}"
