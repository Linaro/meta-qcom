DESCRIPTION = "QCOM Firmware for Qualcomm Robotics RB3Gen2 platform"

LICENSE = "Proprietary"
LICENSE_FILE = "license.qcom.txt"
LIC_FILES_CHKSUM = "file://${LICENSE_FILE};md5=84caa14f15f706e53a3a6991fb5c31cb"


FW_D_NAME = "QCM6490_MSL"
S = "${WORKDIR}/${FW_D_NAME}"

BB_CHECK_SSL_CERTS = "0"
SRC_URI = "https://artifacts.codelinaro.org/artifactory/clo-386-k2c-yocto/${PV}/${FW_D_NAME}.zip"

SRC_URI[md5sum] = "eee201fdb436808ed2b178f7bcef01b0"
SRC_URI[sha256sum] = "c9663265378d4d0d372c1ee04091b6f66b95ad7682f1c1aefde0876072b3a579"

FW_QCOM_NAME = "qcm6490"
QCM6490_FW_SRC_PATH = "/lib/firmware/qcom/qcm6490"

require recipes-bsp/firmware/firmware-qcom.inc

do_install() {
    install -d ${D}${FW_QCOM_PATH}

    install -m 0644 ${WORKDIR}/${FW_D_NAME}/${QCM6490_FW_SRC_PATH}/*dsp*.mbn ${D}${FW_QCOM_PATH}
    install -m 0644 ${WORKDIR}/${FW_D_NAME}/${QCM6490_FW_SRC_PATH}/*dsp*.jsn ${D}${FW_QCOM_PATH}

    install -d ${D}${sysconfdir}/
    install -m 0644 ${WORKDIR}/${FW_D_NAME}/${LICENSE_FILE} ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}
}

SPLIT_FIRMWARE_PACKAGES = "\
    linux-firmware-qcom-${FW_QCOM_NAME}-audio \
    linux-firmware-qcom-${FW_QCOM_NAME}-compute \
"
