DESCRIPTION = "Tiny ramdisk image with SM8550 HDK devices firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-sm8550-hdk \
"

BAD_RECOMMENDATIONS = " \
"

require initramfs-firmware-image.inc
