DESCRIPTION = "QCOM Firmware for Qualcomm Robotics RB3Gen2 platform"

LICENSE = "Proprietary"
LICENSE_FILE = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${LICENSE_FILE};md5=58d50a3d36f27f1a1e6089308a49b403"

FW_D_NAME = "QCM6490_fw"
S = "${WORKDIR}/${FW_D_NAME}"

BB_CHECK_SSL_CERTS = "0"
SRC_URI = "https://artifacts.codelinaro.org/artifactory/qli-ci/software/chip/qualcomm_linux-spf-1-0/qualcomm-linux-spf-1-0_test_device_public/r1.0_${PV}/QCM6490.LE.1.0/common/build/ufs/bin/${FW_D_NAME}.zip"

SRC_URI[md5sum] = "8bf745bd5ff92d891463968ed4583892"
SRC_URI[sha256sum] = "7e5cec86d3222b1d6625d63776f6c278b41c585ace416f7589e3a99d3550c9eb"

FW_QCOM_NAME = "qcs6490"
QCM6490_FW_SRC_PATH = "/lib/firmware/qcom/qcs6490"

ADRENO_URI = "https://artifacts.codelinaro.org/artifactory/qli-ci/software/chip/qualcomm_linux-spf-1-0/qualcomm-linux-spf-1-0_test_device_public/r1.0_${PV}/le-qclinux-1-0-r1/apps_proc/prebuilt_HY22/adreno_1.0_qcm6490.tar.gz;fwpath=lib/firmware"
SRC_URI[adreno.sha256sum] = "efa9b263faef4e0891b2bc568f9ca18bab1c0e810311c764f0c59ebb5fb1ee39"

require recipes-bsp/firmware/firmware-qcom.inc
require recipes-bsp/firmware/firmware-qcom-adreno.inc

DEPENDS += "pil-squasher-native"

do_install() {
    install -d ${D}${FW_QCOM_PATH}

    install -m 0644 ${B}/${QCM6490_FW_SRC_PATH}/*dsp*.mbn ${D}${FW_QCOM_PATH}
    install -m 0644 ${B}/${QCM6490_FW_SRC_PATH}/*dsp*.jsn ${D}${FW_QCOM_PATH}

    if [ -n "${ADRENO_URI}" ] ; then
        install -m 0644  ${UNPACKDIR}/adreno/${ADRENO_PATH}/a660_sqe.fw ${D}${FW_QCOM_BASE_PATH}
        install -m 0644  ${UNPACKDIR}/adreno/${ADRENO_PATH}/a660_gmu.bin ${D}${FW_QCOM_BASE_PATH}
        install -m 0644  ${UNPACKDIR}/adreno/${ADRENO_PATH}/a660_zap.mbn ${D}${FW_QCOM_BASE_PATH}
    fi

    install -d ${D}${sysconfdir}/
    install -m 0644 ${B}/${LICENSE_FILE} ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}
}

