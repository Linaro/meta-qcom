SUMMARY = "Firmware packages for the RB1 Robotics platform"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a630 linux-firmware-qcom-qcm2290-adreno', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath10k-wcn3990 linux-firmware-qcom-qcm2290-wifi ', '', d)} \
    linux-firmware-lt9611uxc \
    linux-firmware-qcom-qcm2290-audio \
    linux-firmware-qcom-qcm2290-modem \
    linux-firmware-qcom-venus-6.0 \
    hexagon-dsp-binaries-thundercomm-rb1-adsp \
"
