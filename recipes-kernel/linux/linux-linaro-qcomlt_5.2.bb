# Copyright (C) 2014-2019 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 5.2 Kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "release/db845c/qcomlt-5.2"
SRCREV ?= "13e8268d9b5cf3980b6e2766bf00439001c363fd"

COMPATIBLE_MACHINE = "(sdm845|qcs404)"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
