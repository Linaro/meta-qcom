require recipes-graphics/xorg-driver/xorg-driver-video.inc

SUMMARY = "X.Org driver for Adreno mobile GPUs"

#FIXME:
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "virtual/libx11 drm libpciaccess pixman"

SRC_URI[md5sum] = "085642246f217ecd9d03c8699526a653"
SRC_URI[sha256sum] = "7ac0a972d4a5610a1ca32ae0aee2733db907fd017c1c8b9c4c0482540bb985cf"

# add custom xorg.conf file
SRC_URI += "file://freedreno.conf"
FILES_${PN} += "${datadir}/X11/xorg.conf.d"
do_install_append () {
    install -d ${D}/${datadir}/X11/xorg.conf.d
    install -m 0644 ${WORKDIR}/freedreno.conf ${D}/${datadir}/X11/xorg.conf.d
}
