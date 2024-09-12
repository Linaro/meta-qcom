DESCRIPTION = "Tiny ramdisk image with ECS Liva QC710 devices firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-ecs-liva-qc710 \
"

require recipes-bsp/images/initramfs-firmware-image.inc
