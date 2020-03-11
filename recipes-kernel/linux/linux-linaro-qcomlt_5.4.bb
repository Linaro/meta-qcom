# Copyright (C) 2014-2019 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 5.4 Kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit pythonnative

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "release/qcomlt-5.4"
SRCREV ?= "8c79b3d123550fde184d9ef6b3d5e2e530abe0bd"

COMPATIBLE_MACHINE = "(apq8016|apq8096|sdm845)"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
