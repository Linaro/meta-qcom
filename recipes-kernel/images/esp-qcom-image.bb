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

# UFS requires vfat sector size of 4096 (default is 512)
VFAT_SECTOR_SIZE ?= "4096"
EXTRA_IMAGECMD:vfat += " -S ${VFAT_SECTOR_SIZE}"

LINGUAS_INSTALL = ""
