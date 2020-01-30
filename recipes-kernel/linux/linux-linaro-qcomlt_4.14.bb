# Copyright (C) 2014-2018 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linaro Qualcomm Landing team 4.14 Kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

LOCALVERSION ?= "-linaro-lt-qcom"
SRCBRANCH ?= "release/qcomlt-4.14"
SRCREV ?= "8bdd343f96dc838eefba94a051e84c6db4d1c55d"

COMPATIBLE_MACHINE = "(apq8064|apq8016|apq8096)"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
