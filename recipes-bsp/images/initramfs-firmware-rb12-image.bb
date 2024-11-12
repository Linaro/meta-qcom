DESCRIPTION = "Tiny ramdisk image with RB1/RB2 devices firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-rb1 \
    packagegroup-firmware-rb2 \
"

BAD_RECOMMENDATIONS = " \
    hexagon-dsp-binaries-thundercomm-rb1-adsp \
    hexagon-dsp-binaries-thundercomm-rb2-adsp \
    hexagon-dsp-binaries-thundercomm-rb2-cdsp \
    linux-firmware-qcom-venus-6.0 \
"

require initramfs-firmware-image.inc
