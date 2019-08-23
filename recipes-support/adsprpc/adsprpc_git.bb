HOMEPAGE = "https://git.linaro.org/landing-teams/working/qualcomm/libadsprpc.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e868d7526728e9b1c0c4f34730d27754"

SRCREV = "741c1415df731503b3aea8b754223a871081d2f3"
SRC_URI = "git://git.linaro.org/landing-teams/working/qualcomm/libadsprpc.git;branch=master;protocol=https"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

inherit autotools
