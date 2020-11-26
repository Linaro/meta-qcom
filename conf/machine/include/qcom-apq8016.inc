SOC_FAMILY = "apq8016"
require conf/machine/include/qcom-common.inc

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += " \
    qrtr \
    rmtfs \
"

MACHINE_EXTRA_RRECOMMENDS += " \
    fastrpc \
"
