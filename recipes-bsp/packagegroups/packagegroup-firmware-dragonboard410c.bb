SUMMARY = "Firmware packages for the DragonBoard 410c board"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    firmware-qcom-dragonboard410c \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a3xx', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-qcom-apq8016-wifi', '', d)} \
    linux-firmware-qcom-apq8016-modem \
    linux-firmware-qcom-venus-1.8 \
"
