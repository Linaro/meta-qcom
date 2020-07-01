# Copyright (C) 2014-2020 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)
#
# This recipe is disabled by default.
# To enable it add the following line to conf/local.conf:
# PREFERRED_PROVIDER_virtual/kernel = "linux-linaro-qcomlt-dev"

DESCRIPTION = "Linaro Qualcomm Landing team Integration Kernel ${PV}"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

require recipes-kernel/linux/linux-linaro-qcom.inc
require recipes-kernel/linux/linux-qcom-bootimg.inc

SRCBRANCH ?= "integration-linux-qcomlt"
SRCREV ?= "${AUTOREV}"

LINUX_VERSION = "5.8-rc+"
PV = "${LINUX_VERSION}+git${SRCPV}"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"

# Disable by default
DEFAULT_PREFERENCE = "-1"
