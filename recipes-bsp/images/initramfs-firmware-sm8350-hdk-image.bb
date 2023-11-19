DESCRIPTION = "Tiny ramdisk image with SM8350 HDK devices firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-sm8350-hdk \
"

BAD_RECOMMENDATIONS = " \
    linux-firmware-qcom-sm8350-sensors \
"

require initramfs-firmware-image.inc
