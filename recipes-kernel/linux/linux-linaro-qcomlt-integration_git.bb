# Copyright (C) 2018 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team Integration Kernel"

inherit pythonnative

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom-integration"

LINUX_LINARO_QCOM_SRCBRANCH ?= "integration/auto/v4.15-2018-01-15-20-34-03"
SRCBRANCH ?= "${LINUX_LINARO_QCOM_SRCBRANCH}"
LINUX_LINARO_QCOM_SRCREV ?= "975871ff9ffcecf21c3e188e9d3b19f2a4113313"
SRCREV ?= "${LINUX_LINARO_QCOM_SRCREV}"

COMPATIBLE_MACHINE = "(ifc6410|sd-600eval|dragonboard-410c)"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
