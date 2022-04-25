inherit update-alternatives

ALTERNATIVE:${PN}-ath11k = "qca6390-board2"
ALTERNATIVE_LINK_NAME[qca6390-board2] = "${nonarch_base_libdir}/firmware/ath11k/QCA6390/hw2.0/board-2.bin"

ALTERNATIVE:${PN}-ath10k = "qca6174-board2"
ALTERNATIVE_LINK_NAME[qca6174-board2] = "${nonarch_base_libdir}/firmware/ath10k/QCA6174/hw3.0/board-2.bin"

ALTERNATIVE:${PN} = "ar6004-hw13-bdata"
ALTERNATIVE_LINK_NAME[ar6004-hw13-bdata] = "${nonarch_base_libdir}/firmware/ath6k/AR6004/hw1.3/bdata.bin"
