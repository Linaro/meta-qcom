inherit update-alternatives

ALTERNATIVE:${PN}-ath11k = "qca6390-board2"
ALTERNATIVE_LINK_NAME[qca6390-board2] = "/lib/firmware/ath11k/QCA6390/hw2.0/board-2.bin"

ALTERNATIVE:${PN}-ath10k = "qca6174-board2"
ALTERNATIVE_LINK_NAME[qca6174-board2] = "/lib/firmware/ath10k/QCA6174/hw3.0/board-2.bin"
