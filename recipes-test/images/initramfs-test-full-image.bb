require recipes-test/images/initramfs-tiny-image.bb

DESCRIPTION = "Relatively larger ramdisk image for running tests (bootrr, etc)"

PACKAGE_INSTALL += " \
    bluez5 \
    coreutils \
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
    kexec-tools \
    lava-test-shell \
    libdrm-tests \
    lsof \
    ncurses \
    ncurses-terminfo \
    ncurses-terminfo-base \
    pciutils \
    pd-mapper \
    qrtr \
    rmtfs \
    rt-tests \
    stress-ng \
    tqftpserv \
    usbutils \
    util-linux \
    util-linux-chrt \
    wpa-supplicant \
"
