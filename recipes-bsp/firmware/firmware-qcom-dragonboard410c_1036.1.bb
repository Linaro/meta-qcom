# This firmware was not fully tested, so it's disabled by default
#
# Add the following line to local.conf to use it:
# PREFERRED_VERSION_firmware-qcom-dragonboard410c = "1036.1"

require recipes-bsp/firmware/firmware-qcom-dragonboard410c.inc

SRC_URI = 'http://releases.linaro.org/96boards/dragonboard410c/qualcomm/firmware/linux-board-support-package-r1036.1.zip'
SRC_URI[md5sum] = "3092fccf7a97fa319d7732a98425f9d4"
SRC_URI[sha256sum] = "93070f58fa3aa6467baa881935c37c4da2df2a8af3248746931ce3d11a3a1200"

# This should not be selected by default as it is in the 'testing' stage
DEFAULT_PREFERENCE = "-1"
