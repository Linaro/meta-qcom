DESCRIPTION = "Qualcomm Firmware for ECS Liva QC710 devices"

LICENSE = "CLOSED"

FW_QCOM_NAME = "ecs-liva-qc710"
FW_QCOM_SUBDIR = "sc7180/ecs/qc710"
WOA_SUBDIR = "ECS/7180_SHOEBOX"

WOA_CABINETS = " \
    qcdx7180.cab;name=dx \
    qcipa7180.cab;name=ipa \
    qcsubsys_ext_adsp7180.cab;name=adsp \
    qcsubsys_ext_cdsp7180.cab;name=cdsp \
    qcsubsys_ext_mpss7180.cab;name=mpss \
    qcwlan7180.cab;name=wlan \
"

SRC_URI = " \
    ${WOA_SRC_URI} \
"

SRC_URI[dx.sha256sum] = "4ca933e0ed1576608e0a62ed782f5ab9556aaee869f6dbba8d8c761a110c54e3"
SRC_URI[ipa.sha256sum] = "b55886ffdad88caea19ce1fdd2268108832cc60a5374f1bb3a597be0dcf81246"
SRC_URI[adsp.sha256sum] = "8d836758ed94b527b547982c6e52878f4f055ac87633598425694dac68c53052"
SRC_URI[cdsp.sha256sum] = "656e7b42a5df43de4ec8a35acfb722d28b8cc2767546650bc5ce84b22cf6c0c1"
SRC_URI[mpss.sha256sum] = "3d3d1ae4907f822bee7b889ee008e9a5f40c1d31b1a972ac32093fe45b5504e6"
SRC_URI[wlan.sha256sum] = "2b296d3e0fabc6108d855172bd13b051af2d16e380c4a059a017d46003a99868"

SPLIT_FIRMWARE_PACKAGES = "\
    linux-firmware-qcom-${FW_QCOM_NAME}-adreno \
    linux-firmware-qcom-${FW_QCOM_NAME}-audio \
    linux-firmware-qcom-${FW_QCOM_NAME}-compute \
    linux-firmware-qcom-${FW_QCOM_NAME}-ipa \
    linux-firmware-qcom-${FW_QCOM_NAME}-modem \
    linux-firmware-qcom-${FW_QCOM_NAME}-venus \
    linux-firmware-qcom-${FW_QCOM_NAME}-wifi \
"

require firmware-woa.inc
