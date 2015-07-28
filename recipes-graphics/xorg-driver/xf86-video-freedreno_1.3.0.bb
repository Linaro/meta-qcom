require recipes-graphics/xorg-driver/xorg-driver-video.inc

SUMMARY = "X.Org driver for Adreno mobile GPUs"

#FIXME:
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "virtual/libx11 drm libpciaccess pixman"

SRC_URI[md5sum] = "a6bff30ae01a7bb7a3128612d139dacc"
SRC_URI[sha256sum] = "1c9d872d1e7389c7771c33e0070f6eb730c406511afcda63867b096aa3d9301d"

SRC_URI += "file://0001-xa-fix-leaked-xa-tracker.patch"

FILES_${PN} += "${datadir}/X11/xorg.conf.d"
