# Copyright (C) 2014 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 4.4 Kernel"

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "release/qcomlt-4.4"
SRCREV ?= "40e98b46d2d547c44ad1d0a0125cf4c6f963a3d4"

COMPATIBLE_MACHINE = "(apq8016|apq8064|apq8096)"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
