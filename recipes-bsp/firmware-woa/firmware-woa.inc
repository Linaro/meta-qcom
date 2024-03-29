DEPENDS += "cabextract-native"
require recipes-bsp/firmware/firmware-qcom.inc

WOA_FW_URL = "https://github.com/WOA-Project/Qualcomm-Reference-Drivers/raw/master/${WOA_SUBDIR}/${PV}"

do_compile:append() {
    for file in ${WORKDIR}/*cab ; do
        cabextract $file || exit 1
    done
}

do_install:append() {
    install -d ${D}${FW_QCOM_PATH}

    install -m 0644 ${B}/*.mbn ${D}${FW_QCOM_PATH}
    ls ${B}/*.elf && install -m 0644 ${B}/*.elf ${D}${FW_QCOM_PATH}

    install -m 0644 ${WORKDIR}/*.jsn ${D}${FW_QCOM_PATH}
}
