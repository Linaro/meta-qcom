SOC_FAMILY = "sm8250"
require conf/machine/include/soc-family.inc
require conf/machine/include/arm/arch-armv8a.inc

XSERVER_OPENGL ?= " \
    xf86-video-modesetting \
    xserver-xorg-extension-glx \
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

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += " \
    pd-mapper \
    qrtr \
    rmtfs \
    tqftpserv \
"

MACHINE_EXTRA_RRECOMMENDS += " \
    fastrpc \
"

IMAGE_FSTYPES ?= "ext4.gz"
IMAGE_ROOTFS_ALIGNMENT = "4096"

QCOM_BOOTIMG_KERNEL_BASE ?= "0x80000000"
QCOM_BOOTIMG_PAGE_SIZE ?= "4096"
