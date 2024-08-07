SUMMARY = "Firmware packages for the RB3Gen2 platform"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    firmware-qcom-rb3gen2 \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a660', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath11k', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'linux-firmware-qca', '', d)} \
    linux-firmware-qcom-vpu-2.0 \
"
