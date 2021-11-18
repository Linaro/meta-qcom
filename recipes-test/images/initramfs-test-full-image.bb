require recipes-test/images/initramfs-test-image.bb

DESCRIPTION = "Relatively larger ramdisk image for running tests (bootrr, etc)"

PACKAGE_INSTALL += " \
    bootrr \
    coreutils \
    hdparm \
    kexec \
    lsof \
    ncurses \
    ncurses-terminfo \
    ncurses-terminfo-base \
    stress-ng \
    util-linux \
    util-linux-chrt \
    util-linux-lsblk \
"

PACKAGE_INSTALL:append:libc-glibc = " \
    rt-tests \
"

# We'd like to include extra packages provided by layers which we do not depend
# on. This can be handled by .bbappends, but then image recipes including this
# one would not get all these tools. So simulate dynamic bbappend here.
PACKAGE_INSTALL_openembedded-layer += " \
    crash \
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
