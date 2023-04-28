FACTORY_NAME ?= "${FW_QCOM_NAME}"
SRC_URI += "https://dl.google.com/dl/android/aosp/${FACTORY_NAME}-${AOSP_BUILD}-factory-${CHECKSUM_factory}.zip;name=factory"

DEPENDS += "pil-squasher-native qc-image-unpacker-native"

do_extract[depends] += "mtools-native:do_populate_sysroot"

do_extract:append() {
    mkdir -p ${B}/radio
    radio="${WORKDIR}/${FACTORY_NAME}-${AOSP_BUILD}/radio-*img"
    if [ "${RADIO_VFAT}" = "1" ] ; then
        mcopy -i $radio ::/image/* ${B}/radio
    else
        rm -rf ${radio}_images
        qc_image_unpacker -i $radio -f || exit 1
        if [ "${RADIO_ROOTDIR}" = "1" ] ; then
            mcopy -i ${radio}_images/modem ::/* ${B}/radio
        else
            mcopy -i ${radio}_images/modem ::/image/* ${B}/radio
        fi
    fi
}

do_compile:append() {
    pil-squasher ${B}/radio/modem.mbn ${B}/radio/modem.mdt
    if [ -r ${B}/radio/mba.mdt ] ; then
        pil-squasher ${B}/radio/mba.mbn ${B}/radio/mba.mdt
    fi
}

do_install:append() {
    install -d ${D}${FW_QCOM_PATH}
    install -m 0644 ${B}/radio/*.mbn ${D}${FW_QCOM_PATH}
}
