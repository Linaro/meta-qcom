DESCRIPTION = "Tiny ramdisk image with firmware files"

# Do not install anything by default
PACKAGE_INSTALL = ""

PACKAGE_INSTALL:qcom-armv8a = " \
    packagegroup-firmware-dragonboard410c \
    packagegroup-firmware-dragonboard820c \
    packagegroup-firmware-dragonboard845c \
    packagegroup-firmware-rb1 \
    packagegroup-firmware-rb2 \
    packagegroup-firmware-rb3gen2 \
    packagegroup-firmware-rb5 \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'wireless-regdb-static', '', d)} \
"

BAD_RECOMMENDATIONS = " \
    hexagon-dsp-binaries-qcom-db820c-adsp \
    hexagon-dsp-binaries-thundercomm-db845c-adsp \
    hexagon-dsp-binaries-thundercomm-db845c-cdsp \
    hexagon-dsp-binaries-thundercomm-db845c-sdsp \
    hexagon-dsp-binaries-thundercomm-rb1-adsp \
    hexagon-dsp-binaries-thundercomm-rb2-adsp \
    hexagon-dsp-binaries-thundercomm-rb2-cdsp \
    hexagon-dsp-binaries-thundercomm-rb5-adsp \
    hexagon-dsp-binaries-thundercomm-rb5-cdsp \
    hexagon-dsp-binaries-thundercomm-rb5-sdsp \
"

require initramfs-firmware-image.inc
