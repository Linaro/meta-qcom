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

# We'd like to include extra packages provided by layers which we do not depend
# on. This can be handled by .bbappends, but then image recipes including this
# one would not get all these tools. So simulate dynamic bbappend here.
PACKAGE_INSTALL_openembedded-layer += " \
    cryptsetup \
    devmem2 \
"

PACKAGE_INSTALL_networking-layer += " \
    iperf2 \
    iperf3 \
    tcpdump \
"
