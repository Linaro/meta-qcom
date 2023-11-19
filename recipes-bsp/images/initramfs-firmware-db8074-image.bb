DESCRIPTION = "Tiny ramdisk image with Dragonboard APQ8074 firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-dragonboard-apq8074 \
"

require initramfs-firmware-image.inc
