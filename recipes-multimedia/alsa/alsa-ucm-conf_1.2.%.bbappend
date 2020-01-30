FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append_sdm845 = " \
	file://0001-ucm-Add-ucm-files-for-DB845c-HDMI-audio.patch \
	file://0002-ucm-Add-ucm-files-for-DB845c-analog-audio.patch \
	file://0003-DB845c-fix-Defaults.patch \
	file://0004-WIP-make-card-name-explicit.patch \
	file://0005-DB845c-Add-headset-mixer-controls.patch \
	file://0007-ucm-DB845c-update-volume-controls.patch \
	file://0008-ucm-DB845c-remove-headphones-for-now.patch \
	file://0009-ucm-DB845c-adjust-default-volume-of-speakers.patch \
"
