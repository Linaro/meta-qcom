DESCRIPTION = "Tiny ramdisk image with Dragonboard 820c firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-dragonboard820c \
"

require initramfs-firmware-image.inc
