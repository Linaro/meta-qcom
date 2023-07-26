# Specify location of the corresponding NON-HLOS.bin file by adding
# NHLOS_URI:pn-firmware-qcom-sm8350-hdk = "..."  to local.conf. Use "file://"
# if the file is provided locally.

DESCRIPTION = "QCOM Firmware for SM8150 HDK (aka HDK855) board"

LICENSE = "CLOSED"

FW_QCOM_NAME = "sm8150"

FW_QCOM_LIST = "\
    a640_zap.mbn a640_gmu.bin \
    adsp.mbn adspr.jsn adspua.jsn \
    cdsp.mbn cdspr.jsn \
    modem.mbn modemuw.jsn \
    slpi.mbn slpir.jsn \
"

require recipes-bsp/firmware/firmware-qcom.inc
require recipes-bsp/firmware/firmware-qcom-nhlos.inc
include recipes-bsp/firmware/firmware-qcom-adreno.inc

SPLIT_FIRMWARE_PACKAGES = "\
    linux-firmware-qcom-${FW_QCOM_NAME}-adreno \
    linux-firmware-qcom-${FW_QCOM_NAME}-audio \
    linux-firmware-qcom-${FW_QCOM_NAME}-compute \
    linux-firmware-qcom-${FW_QCOM_NAME}-modem \
    linux-firmware-qcom-${FW_QCOM_NAME}-sensors \
    linux-firmware-qcom-adreno-a640 \
"

FILES:linux-firmware-qcom-adreno-a640 += "${FW_QCOM_PATH}/a640_gmu.bin"
RDEPENDS:linux-firmware-qcom-adreno-a640 += "linux-firmware-qcom-adreno-a630"
