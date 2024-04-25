DESCRIPTION = "Tiny ramdisk image with SM8650 HDK devices firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-sm8650-hdk \
"

BAD_RECOMMENDATIONS = " \
"

require initramfs-firmware-image.inc
