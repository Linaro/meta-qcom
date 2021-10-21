DESCRIPTION = "Tiny ramdisk image with firmware files"

PACKAGE_INSTALL = " \
    packagegroup-firmware-dragonboard410c \
    packagegroup-firmware-dragonboard820c \
    packagegroup-firmware-dragonboard845c \
    packagegroup-firmware-rb5 \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'wireless-regdb-static', '', d)} \
"

IMAGE_LINGUAS = ""
LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

# Inhibit installing /init
IMAGE_BUILDING_DEBUGFS = "true"
