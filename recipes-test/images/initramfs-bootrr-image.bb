DESCRIPTION = "Small ramdisk image for running bootrr"

PACKAGE_INSTALL = " \
    ${ROOTFS_BOOTSTRAP_INSTALL} \
    busybox \
    base-passwd \
    devmem2 \
    diag \
    ethtool \
    gptfdisk \
    iperf2 \
    iperf3 \
    lava-test-shell \
    packagegroup-core-boot \
    qrtr-apps \
    rmtfs \
    tcpdump \
    udev \
"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = "debug-tweaks"

export IMAGE_BASENAME = "initramfs-bootrr-image"
IMAGE_LINGUAS = ""

LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

# Disable installation of kernel and modules via packagegroup-core-boot
NO_RECOMMENDATIONS = "1"
