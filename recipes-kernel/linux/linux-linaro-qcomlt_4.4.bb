# Copyright (C) 2014 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 4.4 Kernel"

inherit pythonnative

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "release/qcomlt-4.4"
SRCREV ?= "4c23d139dbab35c183d94ea69b339c1b4c9fd14c"

COMPATIBLE_MACHINE = "(ifc6410|sd-600eval|dragonboard-410c)"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
