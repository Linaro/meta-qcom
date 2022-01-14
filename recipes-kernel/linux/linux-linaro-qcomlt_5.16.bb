# Copyright (C) 2021 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-linaro-qcom.inc

COMPATIBLE_MACHINE = "(sa8155p)"
SRC_URI:append = " file://0001-Revert-kbuild-Enable-DT-schema-checks-for-.dtb-targe.patch"
SRCBRANCH = "release/sa8155p-adp/qcomlt-5.16"
SRCREV = "8ea62eb83b9da1402d505146c529bcca87b7ba80"
