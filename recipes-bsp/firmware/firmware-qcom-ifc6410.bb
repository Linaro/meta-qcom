# Specify location of the corresponding NON-HLOS.bin file by adding
# NHLOS_URI:pn-firmware-qcom-ifc6410 = "..."  to local.conf. Use "file://"
# if the file is provided locally.

DESCRIPTION = "QCOM Firmware for Inforce IFC6410 board"

LICENSE = "CLOSED"

# ifc6410 firmware is unsigned, so install into generic location
FW_QCOM_NAME = "apq8064"

FW_QCOM_LIST = "dsps.mbn gss.mbn q6.mbn wcnss.mbn"

S = "${UNPACKDIR}"

require recipes-bsp/firmware/firmware-qcom.inc
require recipes-bsp/firmware/firmware-qcom-nhlos.inc

SPLIT_FIRMWARE_PACKAGES = " \
    linux-firmware-qcom-${FW_QCOM_NAME}-dsps \
    linux-firmware-qcom-${FW_QCOM_NAME}-gss \
    linux-firmware-qcom-${FW_QCOM_NAME}-q6 \
    linux-firmware-qcom-${FW_QCOM_NAME}-wifi \
"
