DESCRIPTION = "Small ramdisk image for running bootrr"

PACKAGE_INSTALL = "bootrr-init busybox base-passwd ${ROOTFS_BOOTSTRAP_INSTALL} qrtr-apps udev bootrr rmtfs gptfdisk lava-test-shell"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = ""

export IMAGE_BASENAME = "initramfs-bootrr-image"
IMAGE_LINGUAS = ""

LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

BAD_RECOMMENDATIONS += "busybox-syslog"
