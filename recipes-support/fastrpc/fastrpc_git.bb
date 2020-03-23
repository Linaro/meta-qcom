HOMEPAGE = "https://git.linaro.org/landing-teams/working/qualcomm/fastrpc.git"
SUMMARY = "Qualcomm FastRPC applications and library"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/fastrpc_apps_user.c;beginline=1;endline=29;md5=f94f3a7beba14ae2f59f817e9634f891"

SRCREV = "388d868b3146fa7ccbeb6aa8c71485ebbbf5e1b9"
SRC_URI = "git://git.linaro.org/landing-teams/working/qualcomm/fastrpc.git;branch=automake;protocol=https"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

inherit autotools
