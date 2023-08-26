SUMMARY = "Firmware packages for the DragonBoard 820c board"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    firmware-qcom-dragonboard820c \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a530 linux-firmware-qcom-apq8096-adreno', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath10k', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'linux-firmware-qca', '', d)} \
    linux-firmware-qcom-apq8096-audio \
    linux-firmware-qcom-apq8096-modem \
    linux-firmware-qcom-venus-4.2 \
"
