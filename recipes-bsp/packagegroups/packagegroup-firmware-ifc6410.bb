SUMMARY = "Firmware packages for the IFC6410 board"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a3xx', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath6k firmware-ath6kl', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'linux-firmware-ar3k', '', d)} \
    firmware-qcom-ifc6410 \
    linux-firmware-qcom-apq8064-dsps \
    linux-firmware-qcom-apq8064-gss \
    linux-firmware-qcom-apq8064-q6 \
    linux-firmware-qcom-apq8064-wifi \
"
