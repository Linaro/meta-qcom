# Copyright (C) 2014 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 4.9 Kernel"

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "db820c/qcomlt-4.9"
SRCREV ?= "5a5796596323bfee4547323e649216401e4b642a"

COMPATIBLE_MACHINE = "(apq8064|apq8016|apq8096)"

# preferred kernel branch for 8064 and 8016 is 4.4
DEFAULT_PREFERENCE_apq8064 = "-1"
DEFAULT_PREFERENCE_apq8016 = "-1"

# Wifi firmware has a recognizable arch :(
ERROR_QA_remove = "arch"
