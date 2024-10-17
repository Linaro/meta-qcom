SUMMARY = "Firmware packages for the IFC6560 board"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a530 linux-firmware-qcom-sda660-adreno', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'linux-firmware-qca', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath10k-wcn3990', '', d)} \
    firmware-qcom-ifc6560 \
    linux-firmware-qcom-sda660-audio \
    linux-firmware-qcom-sda660-compute \
    linux-firmware-qcom-sda660-modem \
    linux-firmware-qcom-sda660-venus \
"
