SUMMARY = "Firmware packages for the DragonBoard 410c board"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    firmware-qcom-dragonboard410c \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a3xx', '', d)} \
    linux-firmware-qcom-venus-1.8 \
"
