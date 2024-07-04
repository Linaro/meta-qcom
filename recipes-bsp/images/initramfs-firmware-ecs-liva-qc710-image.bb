DESCRIPTION = "Tiny ramdisk image with ECS Liva QC710 devices firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-ecs-liva-qc710 \
"

require initramfs-firmware-image.inc
