SUMMARY = "Firmware packages for the SM8650-HDK board"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'linux-firmware-qca', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath12k', '', d)} \
    firmware-qcom-sm8650-hdk \
    linux-firmware-lt9611uxc \
    linux-firmware-qcom-sm8650-audio \
    linux-firmware-qcom-sm8650-compute \
    linux-firmware-qcom-sm8650-ipa \
"
