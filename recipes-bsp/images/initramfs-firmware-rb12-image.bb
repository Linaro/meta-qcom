DESCRIPTION = "Tiny ramdisk image with RB1/RB2 devices firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-rb1 \
    packagegroup-firmware-rb2 \
"

BAD_RECOMMENDATIONS = " \
    firmware-qcom-rb1-dspso \
    firmware-qcom-rb2-dspso \
    linux-firmware-qcom-venus-6.0 \
"

require initramfs-firmware-image.inc
