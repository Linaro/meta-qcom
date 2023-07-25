SUMMARY = "Firmware packages for the RB2 Robotics platform"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    firmware-qcom-rb2 \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a630 linux-firmware-qcom-qrb4210-zap-shader', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath10k linux-firmware-qcom-qrb4210-wifi', '', d)} \
    linux-firmware-qcom-qrb4210-audio \
    linux-firmware-qcom-qrb4210-compute \
    linux-firmware-qcom-qrb4210-modem \
    linux-firmware-qcom-venus-6.0 \
"
