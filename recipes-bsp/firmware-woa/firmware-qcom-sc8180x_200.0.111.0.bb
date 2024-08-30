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
SRC_URI[ipa.sha256sum] = "41545f9dacc3112a05361817b90d5cd344fc827b7a11ee1147cff1d2c5556961"
SRC_URI[adsp.sha256sum] = "871540e5a327a524a1c6872b4a143ceb37d9851eb1e0bc58e0f8812efea0270e"
SRC_URI[cdsp.sha256sum] = "3b0393ffbe874e15e85eabda74bebbdba9096738712071849fd900a961e253e6"
SRC_URI[mpss.sha256sum] = "55930759a52af8f4d903ccaa00b394747a85169378d19ca0b1c390d57d82f76c"
SRC_URI[slpi.sha256sum] = "bf3a476607c6f1ccf13559b9527c36be04270c90536bc64205b783eb4dcb839e"
SRC_URI[wlan.sha256sum] = "3ea329906cac3e7d0c320f77f12954c9b66bcce9970ed497d7f5f9905869ac68"

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
