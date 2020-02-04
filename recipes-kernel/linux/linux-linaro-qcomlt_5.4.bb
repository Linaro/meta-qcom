# Copyright (C) 2014-2019 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 5.4 Kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "release/qcomlt-5.4"
SRCREV ?= "8a9b29362e55e16171a30705207f350ac23cb3a2"

COMPATIBLE_MACHINE = "(apq8016|apq8096|sdm845)"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
