# To make the layer pass yocto-check-layer only inherit update-alternatives when building for qualcomm
ALTERNATIVES_CLASS = ""
ALTERNATIVES_CLASS:qcom = "update-alternatives"

inherit ${ALTERNATIVES_CLASS}

# firmware-ath6kl provides updated bdata.bin, which can not be accepted into main linux-firmware repo
ALTERNATIVE:${PN}-ath6k:qcom = "ar6004-hw13-bdata"
ALTERNATIVE_LINK_NAME[ar6004-hw13-bdata] = "${nonarch_base_libdir}/firmware/ath6k/AR6004/hw1.3/bdata.bin"

ALTERNATIVE:${PN}-ath11k:qcom += "wcn6855-hw20-amss wcn6855-hw20-m3 wcn6855-hw20-regdb wcn6855-hw20-notice wcn6855-hw20-board-2"
ALTERNATIVE_LINK_NAME[wcn6855-hw20-amss] = "${nonarch_base_libdir}/firmware/ath11k/WCN6855/hw2.0/amss.bin"
ALTERNATIVE_LINK_NAME[wcn6855-hw20-m3] = "${nonarch_base_libdir}/firmware/ath11k/WCN6855/hw2.0/m3.bin"
ALTERNATIVE_LINK_NAME[wcn6855-hw20-regdb] = "${nonarch_base_libdir}/firmware/ath11k/WCN6855/hw2.0/regdb.bin"
ALTERNATIVE_LINK_NAME[wcn6855-hw20-notice] = "${nonarch_base_libdir}/firmware/ath11k/WCN6855/hw2.0/Notice.txt"
ALTERNATIVE_LINK_NAME[wcn6855-hw20-board-2] = "${nonarch_base_libdir}/firmware/ath11k/WCN6855/hw2.0/board-2.bin"
