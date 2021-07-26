# Copyright (C) 2014-2020 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 5.13 Kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

require recipes-kernel/linux/linux-linaro-qcom.inc

LOCALVERSION ?= "-linaro-lt-qcom"

SRCBRANCH = "release/qcomlt-5.13"
SRCREV = "736f3cc95d740e27632aba7e2bda09dfd9bdf2a3"

COMPATIBLE_MACHINE = "(qcom)"
