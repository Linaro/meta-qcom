# Copyright (C) 2014-2019 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 5.7 Kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit python3native

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "release/qcomlt-5.7"
SRCREV ?= "ba75ed77ea9ee88706bd1b78512f4f86040feb6c"

COMPATIBLE_MACHINE = "(apq8016|apq8096|sdm845|sm8250)"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
