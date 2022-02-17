SUMMARY = "Firmware packages for the RB5 Robotics platform"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    firmware-qcom-rb5 \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a650', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath11k', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'linux-firmware-qca', '', d)} \
    linux-firmware-lt9611uxc \
    linux-firmware-qcom-sm8250-audio \
    linux-firmware-qcom-sm8250-compute \
    linux-firmware-qcom-vpu-1.0 \
"
