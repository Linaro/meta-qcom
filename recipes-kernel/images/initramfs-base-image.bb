DESCRIPTION = "Base ramdisk image for release and running tests"

PACKAGE_INSTALL = " \
    ${ROOTFS_BOOTSTRAP_INSTALL} \
    busybox \
    base-passwd \
    e2fsprogs \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-resize2fs \
    e2fsprogs-tune2fs \
    packagegroup-core-boot \
"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = "debug-tweaks"

IMAGE_LINGUAS = ""

LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"
