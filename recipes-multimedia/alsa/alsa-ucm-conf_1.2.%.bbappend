FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append_sdm845 = " \
	file://0001-ucm2-codecs-wcd934x-Add-Codec-sequences.patch \
	file://0002-ucm2-codecs-wsa881x-add-codec-sequences.patch \
	file://0003-ucm2-DB845c-Add-ucm-for-DB845c-board.patch \
	file://0004-ucm2-Add-ucm-for-Lenovo-YOGA-C630-13Q50-laptop.patch \
	file://0005-ucm2-Lenovo-YOGA-C630-remove-cdev-which-is-already-p.patch \
	file://0006-ucm2-DB845c-remove-cdev-which-is-already-present-in-.patch \
	file://0007-ucm2-DB845c-HDMI-update-cdev-to-correct-value.patch \
"
