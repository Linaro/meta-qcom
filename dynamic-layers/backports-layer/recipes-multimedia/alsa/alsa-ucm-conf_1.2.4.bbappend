FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append_qcom = "\
    file://0001-ucm2-Separate-the-configuration-lookups-hw-based-fro.patch \
    file://0001-ucm2-conf.d-add-symlinks-for-Qualcomm-cards.patch \
    file://0001-ucm2-codecs-lpass-add-codec-sequences-for-wsa-and-va.patch \
    file://0002-ucm2-add-support-to-for-Qualcomm-RB5-Platform.patch \
"
