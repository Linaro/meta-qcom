DESCRIPTION = "Tiny ramdisk image with X1E80100 CRD devices firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-x1e80100-crd \
"

BAD_RECOMMENDATIONS = " \
    linux-firmware-qca \
    linux-firmware-qcom-x1e80100-crd-compute \
    linux-firmware-qcom-x1e80100-crd-venus \
"

require recipes-bsp/images/initramfs-firmware-image.inc
