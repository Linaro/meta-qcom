SUMMARY = "Firmware packages for the Lenovo X13s laptop"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-sc8280xp-lenovo-x13s-adreno', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath11k', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'linux-firmware-qca', '', d)} \
    linux-firmware-qcom-sc8280xp-lenovo-x13s-audio \
    linux-firmware-qcom-sc8280xp-lenovo-x13s-compute \
    linux-firmware-qcom-sc8280xp-lenovo-x13s-sensors \
"
