DESCRIPTION = "Small ramdisk image for running bootrr"

INITRAMFS_SCRIPTS ?= "\
    initramfs-framework-base \
    initramfs-module-udev \
    initramfs-module-debug \
    initramfs-module-exec \
                     "

PACKAGE_INSTALL = " \
    ${INITRAMFS_SCRIPTS} \
    ${ROOTFS_BOOTSTRAP_INSTALL} \
    busybox \
    base-passwd \
    devmem2 \
    diag \
    ethtool \
    gptfdisk \
    iperf2 \
    iperf3 \
    qrtr-apps \
    lava-test-shell \
    rmtfs \
    tcpdump \
    udev \
"

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
