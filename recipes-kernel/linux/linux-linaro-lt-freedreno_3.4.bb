# Copyright (C) 2014 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-linaro-qcom.inc

SRC_URI += "file://defconfig"

SRCBRANCH = "freedreno/ifc6410-v2.0-drm"
SRCREV = "602a30a57d9d3807df758221c2224e64a29e6fc7"
