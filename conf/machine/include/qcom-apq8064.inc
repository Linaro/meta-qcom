SOC_FAMILY = "apq8064"
require conf/machine/include/soc-family.inc
require conf/machine/include/tune-cortexa8.inc

XSERVER_OPENGL ?= "xf86-video-modesetting \
                   xserver-xorg-extension-glx \
                  "

XSERVER = " \
	xserver-xorg \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '${XSERVER_OPENGL}', 'xf86-video-fbdev', d)} \
	xf86-input-mouse \
	xf86-input-keyboard \
	xf86-input-evdev \
"

PREFERRED_PROVIDER_virtual/egl ?= "mesa"
PREFERRED_PROVIDER_virtual/libgl ?= "mesa"
PREFERRED_PROVIDER_virtual/libgles1 ?= "mesa"
PREFERRED_PROVIDER_virtual/libgles2 ?= "mesa"
PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
PREFERRED_PROVIDER_virtual/kernel = "linux-linaro-qcomlt"

# Fastboot expects an ext4 image, which needs to be 4096 aligned
IMAGE_FSTYPES ?= "ext4.gz"
IMAGE_ROOTFS_ALIGNMENT = "4096"

QCOM_BOOTIMG_KERNEL_BASE ?= "0x80200000"
QCOM_BOOTIMG_PAGE_SIZE ?= "2048"
