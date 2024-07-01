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

SRC_URI[dx.sha256sum] = "c5295509720898758e9a61f1f5f64a013cb6c7706e82d1598232cdca5754d115"
SRC_URI[ipa.sha256sum] = "e083779b7ee99edfd0fc4a54fb562c355476cf359f29cc729052158f97c3769d"
SRC_URI[adsp.sha256sum] = "0679e45ae07b4b19db97ac06b12fce64cba4dfe65102d1f615564ca90387e8dd"
SRC_URI[cdsp.sha256sum] = "eb6b1ff4d02736cd2b2ecaaf4136c164d712fcec7d8ad232434be1c67b703ffc"
SRC_URI[mpss.sha256sum] = "7c7ed01e9c8cff1c7d1546a2b6f14c23d9224afd0de9a6f52c33ad04bfe053a8"
SRC_URI[slpi.sha256sum] = "4dc4be421f46ffa3ee8b9141faac4214e7d19e60dc7c63734ef2bdba08cca73d"

SPLIT_FIRMWARE_PACKAGES = "\
    linux-firmware-qcom-${FW_QCOM_NAME}-adreno \
    linux-firmware-qcom-${FW_QCOM_NAME}-audio \
    linux-firmware-qcom-${FW_QCOM_NAME}-compute \
    linux-firmware-qcom-${FW_QCOM_NAME}-ipa \
    linux-firmware-qcom-${FW_QCOM_NAME}-modem \
    linux-firmware-qcom-${FW_QCOM_NAME}-sensors \
    linux-firmware-qcom-${FW_QCOM_NAME}-venus \
"

require firmware-woa.inc
