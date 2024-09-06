# do not override KBRANCH and SRCREV_machine, use default ones.
COMPATIBLE_MACHINE:qcom = "qcom-armv8a|qcom-armv7a"

FILESEXTRAPATHS:prepend:qcom := "${THISDIR}/${PN}:"

# include all Qualcomm-specific files
SRC_URI:append:qcom = " \
    file://qcom.scc \
"

# For boot.img
QCOM_BOOTIMG = ""
QCOM_BOOTIMG:qcom = "linux-qcom-bootimg"
inherit ${QCOM_BOOTIMG}

# For dtb.bin
QCOM_DTBBIN = ""
QCOM_DTBBIN:qcom = "linux-qcom-dtbbin"
inherit ${QCOM_DTBBIN}
