DESCRIPTION = "Tiny ramdisk image with all Nexus and Pixel devices firmware files"

# Firmware support for newer Nexus and Pixel devices depends on simg2img, which
# is provided by the meta-oe only. So they are split into the bbappend in
# dynamic-layers/openembedded-layer.
PACKAGE_INSTALL += " \
    firmware-qcom-nexus4 \
    firmware-qcom-nexus5 \
    firmware-qcom-nexus5x \
    firmware-qcom-nexus6 \
    firmware-qcom-nexus6p \
    firmware-qcom-nexus7-2013 \
    firmware-qcom-pixel \
    firmware-qcom-pixel2 \
    firmware-qcom-pixel3 \
    firmware-qcom-pixel3a \
    firmware-qcom-pixel4 \
    firmware-qcom-pixel4a \
    firmware-qcom-pixel4a-5g \
    firmware-qcom-pixel5 \
    firmware-qcom-pixel5a-5g \
"

require initramfs-firmware-image.inc
