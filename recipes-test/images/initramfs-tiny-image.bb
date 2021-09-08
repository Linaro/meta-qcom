DESCRIPTION = "Tiny ramdisk image for board bringup"

PACKAGE_INSTALL = " \
    ${ROOTFS_BOOTSTRAP_INSTALL} \
    busybox \
    base-passwd \
    packagegroup-core-boot \
    udev \
"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = "debug-tweaks"
IMAGE_LINGUAS = ""

LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

# Disable installation of kernel and modules via packagegroup-core-boot
NO_RECOMMENDATIONS ?= "1"

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
