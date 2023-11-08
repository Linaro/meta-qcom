# do not override KBRANCH and SRCREV_machine, use default ones.
COMPATIBLE_MACHINE:qcom = "qcom-armv8a"

FILESEXTRAPATHS:prepend:qcom := "${THISDIR}/${PN}:"

# include all Qualcomm-specific files
SRC_URI:append:qcom = " \
    file://qcom.scc \
"

QCOM_BOOTIMG = ""
QCOM_BOOTIMG:qcom = "linux-qcom-bootimg"
inherit ${QCOM_BOOTIMG}
