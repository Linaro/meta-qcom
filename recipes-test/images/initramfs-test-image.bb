require recipes-test/images/initramfs-tiny-image.bb

DESCRIPTION = "Small ramdisk image for running tests (bootrr, etc)"

PACKAGE_INSTALL += " \
    alsa-utils-alsaucm \
    alsa-utils-amixer \
    alsa-utils-aplay \
    alsa-utils-speakertest \
    cmake \
    bluez5 \
    dhcpcd \
    diag \
    dropbear \
    e2fsprogs \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-resize2fs \
    e2fsprogs-tune2fs \
    ethtool \
    fastrpc \
    git \
    gptfdisk \
    i2c-tools \
    iw \
    lava-test-shell \
    libdrm-tests \
    lrzsz \
    make \
    pciutils \
    pd-mapper \
    qrtr \
    rmtfs \
    strace \
    tqftpserv \
    usbutils \
    util-linux-lscpu \
    util-linux-taskset \
    wpa-supplicant \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'kmscube', '', d)} \
"

# We'd like to include extra packages provided by layers which we do not depend
# on. This can be handled by .bbappends, but then image recipes including this
# one would not get all these tools. So simulate dynamic bbappend here.
PACKAGE_INSTALL_openembedded-layer += " \
    cpufrequtils \
    cryptsetup \
    devmem2 \
    lmsensors-config-libsensors \
    lmsensors-sensors \
"

PACKAGE_INSTALL_networking-layer += " \
    iperf2 \
    iperf3 \
    phytool \
    tcpdump \
"
