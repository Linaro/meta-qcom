SOC_FAMILY = "apq8096"
require conf/machine/include/qcom-common.inc
require conf/machine/include/arm/arch-armv8a.inc

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += " \
    qrtr \
    rmtfs \
"

MACHINE_EXTRA_RRECOMMENDS += " \
    fastrpc \
"
