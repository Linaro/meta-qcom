FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append = " file://0001-iplink_rmnet-Allow-passing-IFLA_RMNET_FLAGS.patch "
