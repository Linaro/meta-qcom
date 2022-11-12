LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://license.txt;md5=0d238870f50c84250a14191d17aaf1d5"

SRC_URI = "https://dl.google.com/dl/android/aosp/qcom-${FW_QCOM_NAME}-${AOSP_BUILD}-${CHECKSUM_qcom}.tgz;name=qcom"

PV = "${AOSP_BUILD}"

require recipes-bsp/firmware/firmware-qcom.inc

DEPENDS += "pil-squasher-native"

# extract the license file
do_extract() {
    head -n 280 ${WORKDIR}/extract-qcom-${FW_QCOM_NAME}.sh | tail -n +16 > ${S}/license.txt
    tail -n +315 ${WORKDIR}/extract-qcom-${FW_QCOM_NAME}.sh | tar xzfv - -C ${S}
}
addtask extract after do_unpack before do_patch

do_compile() {
    for fw in ${S}/vendor/qcom/${FW_QCOM_NAME}/proprietary/*.mdt ; do
        pil-squasher ${B}/`basename $fw mdt`mbn $fw
    done
}

do_install() {
    install -d ${D}${FW_QCOM_PATH}
    install -m 0644 license.txt ${D}${FW_QCOM_PATH}
}
