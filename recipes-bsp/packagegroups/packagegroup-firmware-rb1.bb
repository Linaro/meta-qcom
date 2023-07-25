SUMMARY = "Firmware packages for the RB1 Robotics platform"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    firmware-qcom-rb1 \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a630 linux-firmware-qcom-qcm2290-zap-shader', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath10k linux-firmware-qcom-qcm2290-wifi ', '', d)} \
    linux-firmware-qcom-qcm2290-audio \
    linux-firmware-qcom-qcm2290-modem \
    linux-firmware-qcom-venus-6.0 \
"
