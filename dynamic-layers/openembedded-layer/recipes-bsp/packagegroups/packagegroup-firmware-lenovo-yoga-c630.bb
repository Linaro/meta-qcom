SUMMARY = "Firmware packages for the Lenogo Yoga C630 laptop"

inherit packagegroup

RRECOMMENDS:${PN} += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'linux-firmware-qcom-adreno-a630 linux-firmware-qcom-lenovo-yoga-c630-adreno', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'linux-firmware-qca', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'linux-firmware-ath10k-wcn3990', '', d)} \
    firmware-qcom-lenovo-yoga-c630 \
    linux-firmware-qcom-lenovo-yoga-c630-audio \
    linux-firmware-qcom-lenovo-yoga-c630-compute \
    linux-firmware-qcom-lenovo-yoga-c630-ipa \
    linux-firmware-qcom-lenovo-yoga-c630-modem \
    linux-firmware-qcom-lenovo-yoga-c630-sensors \
    linux-firmware-qcom-lenovo-yoga-c630-venus \
    linux-firmware-qcom-lenovo-yoga-c630-wifi \
"
