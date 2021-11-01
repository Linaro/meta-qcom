DESCRIPTION = "QCOM Firmware for Asus Google Nexus 7 (2013)"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://license.txt;md5=0d238870f50c84250a14191d17aaf1d5"

SRC_URI = "https://dl.google.com/dl/android/aosp/qcom-flo-mob30x-43963492.tgz;name=google \
    git://android.googlesource.com/device/asus/flo;protocol=https;branch=master;name=aosp"
SRC_URI[google.md5sum] = "5c21950c751544cc92b5fe95c6f3be37"
SRC_URI[google.sha256sum] = "1ccc740a461be8ea84369b1c13fc89cb3f26f8bc1400fedec8b3dd1f630a7994"
SRCREV_aosp = "9d9fee956a9c4c7be4f69f7a472d3fc0e759c2dd"

FW_QCOM_NAME = "flo"

require recipes-bsp/firmware/firmware-qcom.inc

DEPENDS += "pil-squasher-native"

# extract the license file
do_extract() {
    head -n 280 ${WORKDIR}/extract-qcom-flo.sh | tail -n +16 > ${S}/license.txt
    tail -n +315 ${WORKDIR}/extract-qcom-flo.sh | tar xzfv - -C ${S}
}
addtask extract after do_unpack before do_patch

do_compile() {
    for fw in ${S}/vendor/qcom/flo/proprietary/*.mdt ; do
        pil-squasher ${B}/`basename $fw mdt`mbn $fw
    done
}

do_install() {
    install -d  ${D}${FW_QCOM_PATH}
    install -m 0644 ${B}/*.mbn ${D}${FW_QCOM_PATH}
    install -m 0644 vendor/qcom/flo/proprietary/vidcfw.elf ${D}${FW_QCOM_PATH}
    install -m 0644 vendor/qcom/flo/proprietary/vidc_1080p.fw ${D}${FW_QCOM_PATH}

    install -m 0644 license.txt ${D}${FW_QCOM_PATH}

    install -m 0644 ${WORKDIR}/git/WCNSS_cfg.dat ${D}${FW_QCOM_PATH}
    install -m 0644 ${WORKDIR}/git/WCNSS_qcom_wlan_nv_deb.bin ${D}${FW_QCOM_PATH}
    install -m 0644 ${WORKDIR}/git/WCNSS_qcom_wlan_nv_flo.bin ${D}${FW_QCOM_PATH}/WCNSS_qcom_wlan_nv.bin
}
