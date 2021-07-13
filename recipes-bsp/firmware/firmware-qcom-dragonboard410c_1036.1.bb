# This firmware is not released for redistribution, however it can be
# downloaded from https://developer.qualcomm.com/hardware/dragonboard-410c
#
# Add the following line to local.conf to use it:
# PREFERRED_VERSION_firmware-qcom-dragonboard410c = "1036.1"
# You have to manually put the downloaded file into ${DL_DIR}

require recipes-bsp/firmware/firmware-qcom-dragonboard410c.inc

SRC_URI = '${@oe.utils.conditional("PREFERRED_VERSION_firmware-qcom-dragonboard410c", "1036.1", "file://dragonboard_410c.zip.1.0-r1036.1.zip", "", d)}'
SRC_URI[md5sum] = "3092fccf7a97fa319d7732a98425f9d4"
SRC_URI[sha256sum] = "93070f58fa3aa6467baa881935c37c4da2df2a8af3248746931ce3d11a3a1200"

# This should not be selected by default as the firmware archive is behind the accept&click wall.
DEFAULT_PREFERENCE = "-1"
