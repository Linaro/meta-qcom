require recipes-test/images/initramfs-tiny-image.bb

DESCRIPTION = "Relatively larger ramdisk image for running tests (bootrr, etc)"

PACKAGE_INSTALL += " \
    bluez5 \
    coreutils \
    dhcp-client \
    diag \
    e2fsprogs \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-resize2fs \
    e2fsprogs-tune2fs \
    ethtool \
    gptfdisk \
    iw \
    hdparm \
    kexec \
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
    stress-ng \
    tqftpserv \
    usbutils \
    util-linux \
    util-linux-chrt \
    util-linux-lsblk \
    wpa-supplicant \
"

PACKAGE_INSTALL:append:libc-glibc += " \
    rt-tests \
"

# We'd like to include extra packages provided by layers which we do not depend
# on. This can be handled by .bbappends, but then image recipes including this
# one would not get all these tools. So simulate dynamic bbappend here.
PACKAGE_INSTALL_openembedded_layer += " \
    crash \
    cryptsetup \
    devmem2 \
    dhrystone \
    iozone3 \
    libgpiod \
    libgpiod-tools \
    lmbench \
    makedumpfile \
    mbw \
    sysbench \
    tinymembench \
    tiobench \
    whetstone \
"

PACKAGE_INSTALL_networking_layer += " \
    iperf2 \
    iperf3 \
    tcpdump \
"

PACKAGE_INSTALL += "${@bb.utils.contains("BBFILE_COLLECTIONS", "openembedded-layer", "${PACKAGE_INSTALL_openembedded_layer}", "", d)}"
PACKAGE_INSTALL += "${@bb.utils.contains("BBFILE_COLLECTIONS", "networking-layer", "${PACKAGE_INSTALL_networking_layer}", "", d)}"
