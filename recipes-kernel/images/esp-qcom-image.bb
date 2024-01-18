DESCRIPTION = "EFI System Partition Image to boot Qualcomm boards"

COMPATIBLE_HOST = '(x86_64.*|arm.*|aarch64.*)-(linux.*)'

PACKAGE_INSTALL = " \
    kernel-devicetree \
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
