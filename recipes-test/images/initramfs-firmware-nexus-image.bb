DESCRIPTION = "Tiny ramdisk image with all Nexus and Pixel devices firmware files"

# We do not use kernel image or kernel modules in the image, so remove the
# dependency on the kernel
KERNELDEPMODDEPEND = ""

PACKAGE_INSTALL += " \
    firmware-qcom-nexus4 \
    firmware-qcom-nexus5 \
    firmware-qcom-nexus5x \
    firmware-qcom-nexus6 \
    firmware-qcom-nexus6p \
    firmware-qcom-nexus7-2013 \
    firmware-qcom-pixel \
    firmware-qcom-pixel2 \
    firmware-qcom-pixel3 \
    firmware-qcom-pixel3a \
    firmware-qcom-pixel4 \
    firmware-qcom-pixel4a \
    firmware-qcom-pixel4a-5g \
    firmware-qcom-pixel5 \
    firmware-qcom-pixel5a-5g \
"

IMAGE_LINGUAS = ""
LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

# Inhibit installing /init
IMAGE_BUILDING_DEBUGFS = "true"
