FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SDM845_PATCHES = " \
	file://0001-ucm2-codecs-wcd934x-Add-Codec-sequences.patch \
	file://0002-ucm2-codecs-wsa881x-add-codec-sequences.patch \
	file://0003-ucm2-DB845c-Add-ucm-for-DB845c-board.patch \
	file://0004-ucm2-Add-ucm-for-Lenovo-YOGA-C630-13Q50-laptop.patch \
	file://0005-ucm2-Lenovo-YOGA-C630-remove-cdev-which-is-already-p.patch \
	file://0006-ucm2-DB845c-remove-cdev-which-is-already-present-in-.patch \
	file://0007-ucm2-DB845c-HDMI-update-cdev-to-correct-value.patch \
"

SRC_URI_append_sdm845 = " \
	${SDM845_PATCHES} \
"

SRC_URI_append_sm8250 = " \
	${SDM845_PATCHES} \
	file://0001-ucm2-codecs-lpass-add-codec-sequences-for-wsa-and-va.patch \
	file://0002-ucm2-add-support-to-for-Qualcomm-RB5-Platform.patch \
"
