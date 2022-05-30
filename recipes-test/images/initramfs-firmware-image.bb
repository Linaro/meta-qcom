DESCRIPTION = "Tiny ramdisk image with firmware files"

# We do not use kernel image or kernel modules in the image, so remove the
# dependency on the kernel
KERNELDEPMODDEPEND = ""
KERNEL_DEPLOY_DEPEND = ""

# Do not install anything by default
PACKAGE_INSTALL = ""

PACKAGE_INSTALL:qcom-armv8a = " \
    packagegroup-firmware-dragonboard410c \
    packagegroup-firmware-dragonboard820c \
    packagegroup-firmware-dragonboard845c \
    packagegroup-firmware-rb5 \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'wireless-regdb-static', '', d)} \
"

BAD_RECOMMENDATIONS = " \
    firmware-qcom-dragonboard820c-dspso \
    firmware-qcom-dragonboard845c-dspso \
    firmware-qcom-rb5-dspso \
"

PACKAGE_INSTALL:qcom-armv7a = " \
    packagegroup-firmware-ifc6410 \
    firmware-qcom-nexus7-2013 \
"

IMAGE_LINGUAS = ""
LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

# Inhibit installing /init
IMAGE_BUILDING_DEBUGFS = "true"
