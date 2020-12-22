# Copyright (C) 2014-2019 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 5.9 Kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"

SRCBRANCH ?= "release/qcomlt-5.9"
SRCREV ?= "ba7408fb46b8301cf4343dde955f45b2de885729"

SRCBRANCH_sm8250 = "release/rb5/qcomlt-5.9"
SRCREV_sm8250 = "6d5a9a5da79684f69e4c66a7cf9108ab4e77025f"

COMPATIBLE_MACHINE = "(apq8016|apq8096|sdm845|sm8250)"
