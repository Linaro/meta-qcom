# Copyright (C) 2021 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-linaro-qcom.inc

# SRCBRANCH set to "release/qcomlt-5.15" in linux-linaro-qcom.inc
SRCREV = "b65f90c953f42781cdfe1858b8fbfb209fab3940"

SRCBRANCH:sa8155p = "release/sa8155p-adp/qcomlt-5.15"
SRCREV:sa8155p = "3290018e72cdf6a1b90e672710ad2a6dda9fffd6"
