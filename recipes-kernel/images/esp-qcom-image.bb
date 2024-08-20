DESCRIPTION = "EFI System Partition Image to boot Qualcomm boards"

PACKAGE_INSTALL = " \
    linux-qcom-uki \
    systemd-boot \
    systemd-bootconf \
"

KERNELDEPMODDEPEND = ""
KERNEL_DEPLOY_DEPEND = ""

inherit image

IMAGE_FSTYPES = "vfat"
IMAGE_FSTYPES_DEBUGFS = ""

LINGUAS_INSTALL = ""
