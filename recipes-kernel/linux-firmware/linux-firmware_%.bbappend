
do_install_append() {
        rm -rf ${D}${nonarch_base_libdir}/firmware/qcom/venus-5.2
        rm -rf ${D}${nonarch_base_libdir}/firmware/qcom/venus-5.4
}


