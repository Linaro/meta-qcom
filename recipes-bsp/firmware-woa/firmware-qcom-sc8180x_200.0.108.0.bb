DESCRIPTION = "Qualcomm Firmware for Compute SC8180X devices"

LICENSE = "CLOSED"

FW_QCOM_NAME = "sc8180x"
WOA_SUBDIR = "8180_CLS"

WOA_CABINETS = " \
    qcdx8180.cab;name=dx \
    qcipa8180.cab;name=ipa \
    qcsubsys_ext_adsp8180.cab;name=adsp \
    qcsubsys_ext_cdsp8180.cab;name=cdsp \
    qcsubsys_ext_mpss8180.cab;name=mpss \
    qcsubsys_ext_scss8180.cab;name=slpi \
    qcwlan8180.cab;name=wlan \
"

SRC_URI = " \
    ${WOA_SRC_URI} \
    file://adspr.jsn \
    file://adspua.jsn \
    file://battmgr.jsn \
    file://cdspr.jsn \
    file://slpir.jsn \
    file://slpius.jsn \
"

SRC_URI[dx.sha256sum] = "33a582149868d2a4fe3c2cded4dbb05128a29248028961438ae687c2feaa9e63"
SRC_URI[ipa.sha256sum] = "e083779b7ee99edfd0fc4a54fb562c355476cf359f29cc729052158f97c3769d"
SRC_URI[adsp.sha256sum] = "a89c65ecebcc17c58851768d69c5d28c7853c207e5cda3cf06f70e2456b1be2c"
SRC_URI[cdsp.sha256sum] = "cecfcdef349d178c53557dfe2ec00ea33b4573e9ea6934bb44a2b328ee4a2f34"
SRC_URI[mpss.sha256sum] = "099cd6f74d44de19925bba98f4f8efc2f70cac12aed9335047a8e4611e536761"
SRC_URI[slpi.sha256sum] = "7f148ef79645612355df415826a5d03aafc6813ce2e06e22b03655a1c84a4b28"
SRC_URI[wlan.sha256sum] = "17a108fdd699f7a66e35509b19612d276ea823f0145413784eb4df17559bcb02"

SPLIT_FIRMWARE_PACKAGES = "\
    linux-firmware-qcom-${FW_QCOM_NAME}-adreno \
    linux-firmware-qcom-${FW_QCOM_NAME}-audio \
    linux-firmware-qcom-${FW_QCOM_NAME}-compute \
    linux-firmware-qcom-${FW_QCOM_NAME}-ipa \
    linux-firmware-qcom-${FW_QCOM_NAME}-modem \
    linux-firmware-qcom-${FW_QCOM_NAME}-sensors \
    linux-firmware-qcom-${FW_QCOM_NAME}-venus \
    linux-firmware-qcom-${FW_QCOM_NAME}-wifi \
"

require firmware-woa.inc
