FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append_qcom = " \
    file://android-gadget-setup.machine \
"
