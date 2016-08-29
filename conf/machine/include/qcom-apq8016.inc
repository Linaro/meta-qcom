SOC_FAMILY = "apq8016"
require conf/machine/include/soc-family.inc
require conf/machine/include/arm/arch-armv8.inc

XSERVER_OPENGL ?= " \
    xf86-video-freedreno \
    xserver-xorg-module-exa \
    xserver-xorg-extension-glx \
    xserver-xorg-extension-dri \
"

XSERVER ?= " \
    xserver-xorg \
    xserver-xorg-module-libint10 \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '${XSERVER_OPENGL}', 'xf86-video-fbdev', d)} \
    xf86-input-evdev \
    xf86-input-mouse \
    xf86-input-keyboard \
"

PREFERRED_PROVIDER_virtual/egl ?= "mesa"
PREFERRED_PROVIDER_virtual/libgl ?= "mesa"
PREFERRED_PROVIDER_virtual/libgles1 ?= "mesa"
PREFERRED_PROVIDER_virtual/libgles2 ?= "mesa"
PREFERRED_PROVIDER_virtual/xserver ?= "xserver-xorg"
PREFERRED_PROVIDER_virtual/kernel ?= "linux-linaro-qcomlt"

KERNEL_DEFCONFIG ?= "${S}/arch/arm64/configs/defconfig"
KERNEL_IMAGETYPE = "Image"

BOOTIMG_PAGE_SIZE ?= "2048"
BOOTIMG_BASE_ADDR ?= "0x80000000"
DT_IMAGE_BASE_NAME ?= "dt-${KERNEL_IMAGE_BASE_NAME}"
DT_IMAGE_SYMLINK_NAME ?= "dt-${KERNEL_IMAGE_SYMLINK_NAME}"

# Fastboot expects an ext4 image, which needs to be 4096 aligned
IMAGE_FSTYPES_append = " ext4.gz"
IMAGE_ROOTFS_ALIGNMENT = "4096"
