require recipes-graphics/xorg-driver/xorg-driver-video.inc

SUMMARY = "X.Org driver for Adreno mobile GPUs"

#FIXME:
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI[md5sum] = "e0f49b1a07ac2d390a1239701b5fcefc"
SRC_URI[sha256sum] = "f5abdd0b09b7ba4bab13440667b00b9be72e734a343d35d8876f08e1b93dc6c1"

DEPENDS += "virtual/libx11 drm libpciaccess pixman"

FILES_${PN} += "${datadir}/X11/xorg.conf.d"
