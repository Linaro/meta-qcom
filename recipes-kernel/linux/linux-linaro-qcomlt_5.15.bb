# Copyright (C) 2021 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-linaro-qcom.inc

# SRCBRANCH set to "release/qcomlt-5.15" in linux-linaro-qcom.inc
SRCREV = "43aa1d1f5fcf5d68f07821b0b3a9314f7c7af649"

SRCBRANCH:sa8155p = "release/sa8155p-adp/qcomlt-5.15"
SRCREV:sa8155p = "3290018e72cdf6a1b90e672710ad2a6dda9fffd6"
