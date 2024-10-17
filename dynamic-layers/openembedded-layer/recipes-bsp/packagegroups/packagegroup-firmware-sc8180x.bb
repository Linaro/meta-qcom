SUMMARY = "Firmware packages for the SC8180X devices"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a640 linux-firmware-qcom-sc8180x-adreno', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'linux-firmware-qca', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath10k-wcn3990', '', d)} \
    firmware-qcom-sc8180x \
    linux-firmware-qcom-sc8180x-audio \
    linux-firmware-qcom-sc8180x-compute \
    linux-firmware-qcom-sc8180x-ipa \
    linux-firmware-qcom-sc8180x-modem \
    linux-firmware-qcom-sc8180x-sensors \
    linux-firmware-qcom-sc8180x-venus \
"
