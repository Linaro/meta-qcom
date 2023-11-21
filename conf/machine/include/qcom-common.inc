SOC_FAMILY:prepend = "qcom:"
require conf/machine/include/soc-family.inc

XSERVER_OPENGL ?= " \
    xf86-video-modesetting \
    xserver-xorg-extension-glx \
"

XSERVER ?= " \
    xserver-xorg \
    xserver-xorg-module-libint10 \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '${XSERVER_OPENGL}', 'xf86-video-fbdev', d)} \
    xf86-input-evdev \
"

PREFERRED_PROVIDER_virtual/egl ?= "mesa"
PREFERRED_PROVIDER_virtual/libgl ?= "mesa"
PREFERRED_PROVIDER_virtual/libgles1 ?= "mesa"
PREFERRED_PROVIDER_virtual/libgles2 ?= "mesa"
PREFERRED_PROVIDER_virtual/xserver ?= "xserver-xorg"
PREFERRED_PROVIDER_virtual/kernel ??= "linux-linaro-qcomlt"

PREFERRED_PROVIDER_android-tools-conf = "android-tools-conf-configfs"

# Fastboot expects an ext4 image, which needs to be 4096 aligned
IMAGE_FSTYPES ?= "ext4.gz"
IMAGE_ROOTFS_ALIGNMENT ?= "4096"

# Android boot image settings
QCOM_BOOTIMG_KERNEL_BASE ?= "0x80000000"
QCOM_BOOTIMG_PAGE_SIZE ?= "4096"

# Default serial console for QCOM devices
SERIAL_CONSOLES ?= "115200;ttyMSM0"

# Increase INITRAMFS_MAXSIZE to 384 MiB to cover initramfs-kerneltest-full
# image.  All our boards (except db410c) have 2GiB and db410c has 1GiB of RAM,
# so this image would fit.
INITRAMFS_MAXSIZE = "393216"
