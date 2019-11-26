SOC_FAMILY = "qcs404"
require conf/machine/include/soc-family.inc
require conf/machine/include/arm/arch-armv8a.inc

PREFERRED_PROVIDER_virtual/kernel ?= "linux-linaro-qcomlt"

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += " \
    qrtr \
"

# Fastboot expects an ext4 image, which needs to be 4096 aligned
IMAGE_FSTYPES ?= "ext4.gz"
IMAGE_ROOTFS_ALIGNMENT = "4096"

QCOM_BOOTIMG_KERNEL_BASE ?= "0x80000000"
QCOM_BOOTIMG_PAGE_SIZE ?= "4096"
