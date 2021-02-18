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

# Set default SRCREV. it is statically set to the korg v3.7 tag, and
# hence prevent network access during parsing. If linux-linaro-qcomlt-dev
# is the preferred provider, they will be overridden to AUTOREV in following
# anonymous python routine and resolved when the variables are finalized.
SRCREV ?= '${@oe.utils.conditional("PREFERRED_PROVIDER_virtual/kernel", "linux-linaro-qcomlt-dev", "${AUTOREV}", "29594404d7fe73cd80eaa4ee8c43dcc53970c60e", d)}'

LINUX_VERSION = "5.11+"
PV = "${LINUX_VERSION}+git${SRCPV}"

# Wifi firmware has a recognizable arch :( 
ERROR_QA_remove = "arch"
