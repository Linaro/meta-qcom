require initramfs-base-image.bb

DESCRIPTION = "Ramdisk image for releases"

# Disable installation of kernel and modules via packagegroup-core-boot
NO_RECOMMENDATIONS = "1"

# Add systemd etc/initrd-release to instruct systemd mount rootfs and do switch_root
initrd_release () {
    mkdir -p ${IMAGE_ROOTFS}/etc
    touch ${IMAGE_ROOTFS}/etc/initrd-release
}
ROOTFS_POSTPROCESS_COMMAND += "${@oe.utils.conditional('VIRTUAL-RUNTIME_init_manager', 'systemd', 'initrd_release;', '', d)}"
