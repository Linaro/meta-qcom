HOMEPAGE = "https://git.linaro.org/landing-teams/working/qualcomm/fastrpc.git"
SUMMARY = "Qualcomm FastRPC applications and library"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/fastrpc_apps_user.c;beginline=1;endline=29;md5=f94f3a7beba14ae2f59f817e9634f891"

SRCREV = "bc36c705c9b057ca880a423021d3c19f02edeadd"
SRC_URI = "git://git.linaro.org/landing-teams/working/qualcomm/fastrpc.git;branch=automake;protocol=https"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

inherit autotools

FILES_${PN} += " \
    ${libdir}/libadsp_default_listener.so \
    ${libdir}/libcdsp_default_listener.so \
"

FILES_${PN}-dev_remove = "${FILES_SOLIBSDEV}"
FILES_${PN}-dev += " \
    ${libdir}/libadsprpc.so \
    ${libdir}/libcdsprpc.so \
"
