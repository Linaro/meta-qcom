# XXX: Checkout previous ath10k stable firmware for dragonboard820c,
# RM.4.4.1.c2-00057-QCARMSWP-1 causes a HW reboot use RM.4.4.1-00079-QCARMSWPZ-1 
do_install_dragonboard-820c_prepend() {
    linux_firmware_ath10k_stable="1d1dd4be21cde408b0fb12774d477293bc8d4cc2"
    cd "${S}"
    git checkout "${linux_firmware_ath10k_stable}" -- ath10k/QCA6174
}
