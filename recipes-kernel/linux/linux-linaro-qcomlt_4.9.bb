# Copyright (C) 2014 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 4.9 Kernel"

inherit pythonnative

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "release/qcomlt-4.9"
SRCREV ?= "529c1db225629896d51b64a481b3760fd81a663a"

COMPATIBLE_MACHINE = "(ifc6410|sd-600eval|dragonboard-410c)"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
