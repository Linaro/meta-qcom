DESCRIPTION = "Qualcomm Firmware for Lenovo Yoga C630 laptop"

LICENSE = "CLOSED"

FW_QCOM_SUBDIR = "msm8998/LENOVO/81F1"
FW_QCOM_NAME = "lenovo-miix-630"
WOA_SUBDIR = "Lenovo/Miix630"

WOA_CABINETS = " \
    qcdx8998.cab;name=dx \
    qcipa8998.cab;name=ipa \
    qcsubsys8998.cab;name=dsp \
"

SRC_URI = "\
    ${WOA_SRC_URI} \
    file://adspr.jsn \
    file://adspua.jsn \
    file://modemr.jsn \
    file://modemuw.jsn \
    file://slpir.jsn \
    file://slpius.jsn \
"

SRC_URI[dx.sha256sum] = "72689ef44a7eae8be5a6eb81a0ee3dc372cfbef988c3f3f39b4ab985b2d2bc4e"
SRC_URI[ipa.sha256sum] = "169bdd9bc312b9b550f8953499c7b7c178b030a5185714e0204c117ccbc2dffe"
SRC_URI[dsp.sha256sum] = "13c356d1e716ce6b3457d4e74eec8dd0c7e9916b534d273c27430df03317ecd5"

SPLIT_FIRMWARE_PACKAGES = "\
    linux-firmware-qcom-${FW_QCOM_NAME}-adreno \
    linux-firmware-qcom-${FW_QCOM_NAME}-audio \
    linux-firmware-qcom-${FW_QCOM_NAME}-ipa \
    linux-firmware-qcom-${FW_QCOM_NAME}-modem \
    linux-firmware-qcom-${FW_QCOM_NAME}-sensors \
    linux-firmware-qcom-${FW_QCOM_NAME}-venus \
    linux-firmware-qcom-${FW_QCOM_NAME}-wifi \
"

require firmware-woa.inc
