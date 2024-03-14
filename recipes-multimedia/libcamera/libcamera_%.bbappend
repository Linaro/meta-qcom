
LIC_FILES_CHKSUM = "\
    file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c \
    file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68 \
"

SRC_URI = " \
    git://gitlab.freedesktop.org/camera/libcamera-softisp.git;protocol=https;branch=SoftwareISP-v08-for-ci \
"
SRC_URI[sha256sum] = "f554084fb8ca63713ef7c59974d741e04ab73d1f031c34e39624a73f5046657e"

SRCREV = "e4424c7d1f0abc71a9217ca5b6aa7dce9872e36b"

LIBCAMERA_PIPELINES = "simple"
