DESCRIPTION = "Tiny ramdisk image with all Nexus and Pixel devices firmware files"

PACKAGE_INSTALL += " \
    packagegroup-firmware-ifc6560 \
"

BAD_RECOMMENDATIONS = "\
    linux-firmware-qcom-sda660-audio \
    linux-firmware-qcom-sda660-compute \
    linux-firmware-qcom-sda660-modem \
    linux-firmware-qcom-sda660-venus \
    linux-firmware-qca \
    linux-firmware-ath10k-wcn3990 \
"

require initramfs-firmware-image.inc
