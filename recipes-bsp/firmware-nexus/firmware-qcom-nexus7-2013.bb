DESCRIPTION = "QCOM Firmware for Asus Google Nexus 7 (2013)"

FW_QCOM_NAME = "flo"
FW_QCOM_SUBDIR = "apq8064/Asus/${FW_QCOM_NAME}"
AOSP_BUILD = "mob30x"
CHECKSUM_qcom = "43963492"

SRC_URI[qcom.sha256sum] = "1ccc740a461be8ea84369b1c13fc89cb3f26f8bc1400fedec8b3dd1f630a7994"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a3xx"

require recipes-bsp/firmware-nexus/firmware-qcom-nexus.inc

SRC_URI += "git://android.googlesource.com/device/asus/${FW_QCOM_NAME};protocol=https;branch=master;name=aosp"
SRCREV_aosp = "9d9fee956a9c4c7be4f69f7a472d3fc0e759c2dd"
PV:append = "+git${SRCPV}"

do_install:append() {
    install -d ${D}${FW_QCOM_PATH}
    install -m 0644 vendor/qcom/flo/proprietary/vidcfw.elf ${D}${FW_QCOM_PATH}

    install -m 0644 ${WORKDIR}/git/WCNSS_cfg.dat ${D}${FW_QCOM_PATH}
    install -m 0644 ${WORKDIR}/git/WCNSS_qcom_wlan_nv_deb.bin ${D}${FW_QCOM_PATH}
    install -m 0644 ${WORKDIR}/git/WCNSS_qcom_wlan_nv_flo.bin ${D}${FW_QCOM_PATH}/WCNSS_qcom_wlan_nv.bin
}
