FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append_qcom = "\
	file://0001-ucm2-codecs-lpass-add-codec-sequences-for-wsa-and-va.patch \
	file://0002-ucm2-add-support-to-for-Qualcomm-RB5-Platform.patch \
	file://0003-ucm.conf-support-KernelModule-CardLongName.conf-path.patch \
	file://0004-module-add-new-symlink-for-Qualcomm-sdm845-driver.patch \
	file://0007-ucm2-module-add-snd_soc_sm8250-symlink.patch \
"
