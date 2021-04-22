require recipes-test/images/initramfs-tiny-image.bb

DESCRIPTION = "Small ramdisk image for running tests (bootrr, etc)"

PACKAGE_INSTALL += " \
    bluez5 \
    dhcpcd \
    diag \
    e2fsprogs \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-resize2fs \
    e2fsprogs-tune2fs \
    ethtool \
    gptfdisk \
    iw \
    lava-test-shell \
    libdrm-tests \
    pciutils \
    pd-mapper \
    qrtr \
    rmtfs \
    tqftpserv \
    usbutils \
    wpa-supplicant \
"
