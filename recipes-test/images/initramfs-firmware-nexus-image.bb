DESCRIPTION = "Tiny ramdisk image with all Nexus and Pixel devices firmware files"

# We do not use kernel image or kernel modules in the image, so remove the
# dependency on the kernel
KERNELDEPMODDEPEND = ""
KERNEL_DEPLOY_DEPEND = ""

# Firmware support for newer Nexus and Pixel devices depends on simg2img, which
# is provided by the meta-oe only. So they are split into the bbappend in
# dynamic-layers/openembedded-layer.
PACKAGE_INSTALL += " \
    firmware-qcom-nexus4 \
    firmware-qcom-nexus5 \
    firmware-qcom-nexus6 \
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
