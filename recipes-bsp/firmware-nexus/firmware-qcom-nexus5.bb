DESCRIPTION = "QCOM Firmware for LGE Google Nexus 5"

FW_QCOM_NAME = "hammerhead"
FW_QCOM_SUBDIR = "msm8974/LGE/${FW_QCOM_NAME}"
AOSP_BUILD = "m4b30z"
CHECKSUM_qcom = "d6c0fe26"
CHECKSUM_factory = "625c027b"

SRC_URI[qcom.sha256sum] = "f8c29461e279b311958f9476ef78b9ab654aeb9903f5c2912f11d5d4bcfd021d"
SRC_URI[factory.sha256sum] = "625c027b21afe6de7c3d0de66e3a42000269dd00c2ef9a5347007734537f3ea2"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a3xx"

require recipes-bsp/firmware-nexus/firmware-qcom-nexus.inc
RADIO_VFAT = "1"
require recipes-bsp/firmware-nexus/firmware-qcom-radio.inc

do_install:append() {
    install -d ${D}${FW_QCOM_PATH}

    install -m 0644 adsp.mbn ${D}${FW_QCOM_PATH}
    install -m 0644 venus.mbn ${D}${FW_QCOM_PATH}
}
