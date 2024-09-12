DESCRIPTION = "Huge image with all firmware files. This is intended to check for possible conflicts, etc."

PACKAGE_INSTALL = " \
    linux-firmware \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'wireless-regdb-static', '', d)} \
"

# Qualcomm Dragonboard / Robotics platforms
PACKAGE_INSTALL += " \
    packagegroup-firmware-dragonboard-apq8074 \
    packagegroup-firmware-dragonboard410c \
    packagegroup-firmware-dragonboard820c \
    packagegroup-firmware-dragonboard845c \
    packagegroup-firmware-rb1 \
    packagegroup-firmware-rb2 \
    packagegroup-firmware-rb3gen2 \
    packagegroup-firmware-rb5 \
"

# Qualcomm HDKs
PACKAGE_INSTALL += " \
    packagegroup-firmware-sm8150-hdk \
    packagegroup-firmware-sm8350-hdk \
    packagegroup-firmware-sm8450-hdk \
    packagegroup-firmware-sm8550-hdk \
    packagegroup-firmware-sm8650-hdk \
"

# Inforce / Penguin Edge devkits
PACKAGE_INSTALL += " \
    packagegroup-firmware-ifc6410 \
    packagegroup-firmware-ifc6560 \
"

# Google Nexus / Pixel devices
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
