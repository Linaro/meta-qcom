DESCRIPTION = "Tiny ramdisk image with Lenovo Yoga C630 firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-lenovo-yoga-c630 \
"

require recipes-bsp/images/initramfs-firmware-image.inc
