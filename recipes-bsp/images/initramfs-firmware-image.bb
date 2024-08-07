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
    firmware-qcom-dragonboard820c-dspso \
    firmware-qcom-dragonboard845c-dspso \
    firmware-qcom-rb1-dspso \
    firmware-qcom-rb2-dspso \
    firmware-qcom-rb5-dspso \
"

PACKAGE_INSTALL:qcom-armv7a = " \
    packagegroup-firmware-ifc6410 \
    firmware-qcom-nexus7-2013 \
"

require initramfs-firmware-image.inc
