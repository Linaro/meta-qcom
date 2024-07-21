inherit packagegroup

RRECOMMENDS:${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a740 linux-firmware-qcom-sm8550-adreno', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'linux-firmware-qca', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath12k', '', d)} \
    firmware-qcom-sm8550-hdk \
    linux-firmware-lt9611uxc \
    linux-firmware-qcom-sm8550-audio \
    linux-firmware-qcom-sm8550-compute \
    linux-firmware-qcom-sm8550-ipa \
    linux-firmware-qcom-sm8550-modem \
"
