# Copyright (C) 2014 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 4.4 Kernel"

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "integration-linux-qcomlt"
SRCREV ?= "5574089362de2fb0ebbc0c4d9bd48203b59b7b1b"
SRC_URI = "${LINUX_LINARO_QCOM_GIT};nobranch=1"

COMPATIBLE_MACHINE = "(apq8064|apq8016|apq8096)"

# Wifi firmware has a recognizable arch :(
ERROR_QA_remove = "arch"
