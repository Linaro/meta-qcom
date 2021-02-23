require recipes-kernel/images/initramfs-base-image.bb

DESCRIPTION = "Small ramdisk image for running tests (bootrr, etc)"

PACKAGE_INSTALL += " \
    bluez5 \
    dhcpcd \
    diag \
    ethtool \
    gptfdisk \
    iw \
    lava-test-shell \
    pciutils \
    pd-mapper \
    qrtr \
    rmtfs \
    tqftpserv \
    udev \
    usbutils \
    wpa-supplicant \
"

# Disable installation of kernel and modules via packagegroup-core-boot
NO_RECOMMENDATIONS = "1"

# Enable local auto-login (on systemd) of the root user (local = serial port and
# virtual console by default, can be configured).
LOCAL_GETTY ?= " \
    ${IMAGE_ROOTFS}${systemd_system_unitdir}/serial-getty@.service \
    ${IMAGE_ROOTFS}${systemd_system_unitdir}/getty@.service \
"
local_autologin () {
    sed -i -e 's/^\(ExecStart *=.*getty \)/\1--autologin root /' ${LOCAL_GETTY}
}
ROOTFS_POSTPROCESS_COMMAND += "${@oe.utils.conditional('VIRTUAL-RUNTIME_init_manager', 'systemd', 'local_autologin;', '', d)}"
