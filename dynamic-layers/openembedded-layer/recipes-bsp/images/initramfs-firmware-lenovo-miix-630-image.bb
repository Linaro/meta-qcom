DESCRIPTION = "Tiny ramdisk image with Lenovo Miix 630 firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-lenovo-miix-630 \
"

require recipes-bsp/images/initramfs-firmware-image.inc
