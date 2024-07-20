# Copyright (C) 2021 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-linaro-qcom.inc

SRCREV = "3565a579b97814fdc93898c9279f6a05106f9a14"

SRC_URI += "\
    file://664a6a0a484ba03eeb29ff64d9c244cb5d54ed51.patch \
    file://9de64bc0c1857e7b504bab874e1b7ef775477e2f.patch \
    file://ae9b80797295a654003f628a92e968950ff9689c.patch \
    file://2f603d83fcc4dbe372f4a74e0ceaa53bf0158cf0.patch \
"
