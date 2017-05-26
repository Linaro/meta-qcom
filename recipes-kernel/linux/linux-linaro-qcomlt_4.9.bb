# Copyright (C) 2014 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 4.9 Kernel"

inherit pythonnative

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "release/qcomlt-4.9"
SRCREV ?= "180b1b7c70a3c567b72421dd9ac1b465527bdf65"

COMPATIBLE_MACHINE = "(apq8016|apq8064|apq8096)"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
