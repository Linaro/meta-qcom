DESCRIPTION = "Tiny ramdisk image with RB1/RB2 devices firmware files"

# We do not use kernel image or kernel modules in the image, so remove the
# dependency on the kernel
KERNELDEPMODDEPEND = ""
KERNEL_DEPLOY_DEPEND = ""

PACKAGE_INSTALL += " \
    packagegroup-firmware-rb1 \
    packagegroup-firmware-rb2 \
"

BAD_RECOMMENDATIONS = " \
    firmware-qcom-rb1-dspso \
    firmware-qcom-rb2-dspso \
    linux-firmware-qcom-venus-6.0 \
"

IMAGE_LINGUAS = ""
LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

# Inhibit installing /init
IMAGE_BUILDING_DEBUGFS = "true"
