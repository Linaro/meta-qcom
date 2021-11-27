require initramfs-rootfs-image.bb

DESCRIPTION = "Ramdisk image for pivoting into rootfs extended to boot Qualcomm boards"

PACKAGE_INSTALL += "packagegroup-qcom-boot"
