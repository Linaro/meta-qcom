SUMMARY = "Firmware packages for the DragonBoard 845c board"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    firmware-qcom-dragonboard845c \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a630 linux-firmware-qcom-sdm845-adreno', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath10k linux-firmware-qcom-sdm845-modem', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'linux-firmware-qca linux-firmware-qcom-sdm845-modem', '', d)} \
    linux-firmware-qcom-sdm845-audio \
    linux-firmware-qcom-sdm845-compute \
    linux-firmware-qcom-venus-5.2 \
"
