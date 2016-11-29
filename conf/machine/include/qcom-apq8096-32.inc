SOC_FAMILY = "apq8096"
require conf/machine/include/soc-family.inc
require conf/machine/include/tune-cortexa8.inc

PREFERRED_PROVIDER_virtual/egl ?= "mesa"
PREFERRED_PROVIDER_virtual/libgl ?= "mesa"
PREFERRED_PROVIDER_virtual/libgles1 ?= "mesa"
PREFERRED_PROVIDER_virtual/libgles2 ?= "mesa"
PREFERRED_PROVIDER_virtual/xserver ?= "xserver-xorg"

# Fastboot expects an ext4 image, which needs to be 4096 aligned
IMAGE_FSTYPES_append = " ext4.gz"
IMAGE_ROOTFS_ALIGNMENT = "4096"
