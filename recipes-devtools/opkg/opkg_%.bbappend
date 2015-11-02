FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
	file://0001-md5-Add-md5_to_string-function.patch \
	file://0002-sha256-Add-sha256_to_string-function.patch \
	file://0003-opkg_download-Use-md5sum-of-src-URI-as-cache-file-na.patch \
"

