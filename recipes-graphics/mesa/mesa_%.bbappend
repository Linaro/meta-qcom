FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

# Enable freedreno driver
PACKAGECONFIG_FREEDRENO = "\
    freedreno \
    tools \
    ${@bb.utils.contains('BBFILE_COLLECTIONS', 'openembedded-layer', 'freedreno-fdperf', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xa', '', d)} \
"

PACKAGECONFIG:append:qcom = "${PACKAGECONFIG_FREEDRENO}"
