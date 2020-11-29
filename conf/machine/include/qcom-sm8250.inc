SOC_FAMILY = "sm8250"
require conf/machine/include/qcom-common.inc
require conf/machine/include/arm/arch-armv8a.inc

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += " \
    pd-mapper \
    qrtr \
    rmtfs \
    tqftpserv \
"

MACHINE_EXTRA_RRECOMMENDS += " \
    fastrpc \
"
