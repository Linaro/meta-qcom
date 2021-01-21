# Copyright (C) 2014-2020 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 5.10 Kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"

SRCBRANCH = "release/qcomlt-5.10"
SRCREV = "ee5a8c43d825506df8e9e0bd3b050c460931351f"

COMPATIBLE_MACHINE = "(apq8016|apq8096|sdm845|sm8250)"
