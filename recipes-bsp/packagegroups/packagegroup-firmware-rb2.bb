SUMMARY = "Firmware packages for the RB2 Robotics platform"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a630 linux-firmware-qcom-qrb4210-adreno', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath10k-wcn3990 linux-firmware-qcom-qrb4210-wifi', '', d)} \
    linux-firmware-lt9611uxc \
    linux-firmware-qcom-qrb4210-audio \
    linux-firmware-qcom-qrb4210-compute \
    linux-firmware-qcom-qrb4210-modem \
    linux-firmware-qcom-venus-6.0 \
    hexagon-dsp-binaries-thundercomm-rb2-adsp \
    hexagon-dsp-binaries-thundercomm-rb2-cdsp \
"
