# Copyright (C) 2014-2021 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 5.12 Kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"

SRCBRANCH = "release/rb5/qcomlt-5.12"
SRCREV = "56d9230c7e441a00b30468071557b68d0fa5ce55"

COMPATIBLE_MACHINE = "(sm8250)"
