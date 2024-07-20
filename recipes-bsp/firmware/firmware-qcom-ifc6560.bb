# Specify location of the corresponding NON-HLOS.bin file by adding
# NHLOS_URI:pn-firmware-qcom-ifc6560 = "..."  to local.conf. Use "file://"
# if the file is provided locally.

DESCRIPTION = "QCOM Firmware for Inforce IFC6560 board"

LICENSE = "CLOSED"

# ifc6560 isn't locked, so install firmware into generic location
FW_QCOM_NAME = "sda660"

FW_QCOM_LIST = "\
    a508_zap.mbn a512_zap.mbn \
    adsp.mbn \
    cdsp.mbn \
    mba.mbn modem.mbn modemuw.jsn \
    venus.mbn \
"

S = "${UNPACKDIR}"

require recipes-bsp/firmware/firmware-qcom.inc
require recipes-bsp/firmware/firmware-qcom-nhlos.inc
require recipes-bsp/firmware/firmware-qcom-adreno.inc

SPLIT_FIRMWARE_PACKAGES = "\
    linux-firmware-qcom-${FW_QCOM_NAME}-adreno \
    linux-firmware-qcom-${FW_QCOM_NAME}-audio \
    linux-firmware-qcom-${FW_QCOM_NAME}-compute \
    linux-firmware-qcom-${FW_QCOM_NAME}-modem \
    linux-firmware-qcom-${FW_QCOM_NAME}-venus \
"
