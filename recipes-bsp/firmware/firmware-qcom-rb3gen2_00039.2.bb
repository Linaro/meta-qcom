DESCRIPTION = "QCOM Firmware for Qualcomm Robotics RB3Gen2 platform"

LICENSE = "Proprietary"
LICENSE_FILE = "LICENSE.qcom"

# The license in the PDF format has been added next to the archive. This file is included in the SRC_URI and will be installed as part of the package for tracking purposes.
# Both the PDF and TXT versions of the license contain same text.
LICENSE_FILE_PDF = "NO.LOGIN.BINARY.LICENSE.QTI.pdf"

LIC_FILES_CHKSUM = "file://${LICENSE_FILE};md5=164e3362a538eb11d3ac51e8e134294b \
    file://${LICENSE_FILE_PDF};md5=4ceffe94cb40cdce6d2f4fb93cc063d1 \
    "

DEPENDS += "qca-swiss-army-knife-native pil-squasher-native"

FW_D_NAME = "QCM6490_fw"

SRC_URI = "\
    https://artifacts.codelinaro.org/artifactory/qli-ci/software/chip/qualcomm_linux-spf-1-0/qualcomm-linux-spf-1-0_test_device_public/r1.0_${PV}/QCM6490.LE.1.0/common/build/ufs/bin/${FW_D_NAME}.zip;name=fw \
    https://artifacts.codelinaro.org/artifactory/qli-ci/software/chip/qualcomm_linux-spf-1-0/qualcomm-linux-spf-1-0_test_device_public/r1.0_${PV}/QCM6490.LE.1.0/common/build/ufs/bin/${LICENSE_FILE_PDF};name=licensepdf \
    https://git.kernel.org/pub/scm/linux/kernel/git/firmware/linux-firmware.git/plain/${LICENSE_FILE};name=license \
    "

SRC_URI[fw.sha256sum] = "7e5cec86d3222b1d6625d63776f6c278b41c585ace416f7589e3a99d3550c9eb"
SRC_URI[licensepdf.sha256sum] = "606e6bab7c428ceac51e920376de65a3e2f7287b45d7ce5d616a8e6e266e51ab"
SRC_URI[license.sha256sum] = "be904cd28cb292b80cdb6cf412ab0d9159d431671e987ad433c1f62e0988a9bc"

FW_QCOM_NAME = "qcs6490"
QCS6490_FW_SRC_PATH = "lib/firmware/qcom/qcs6490"

S = "${UNPACKDIR}"

require recipes-bsp/firmware/firmware-qcom.inc

do_compile:append() {
    pil-squasher wpss.mbn ${UNPACKDIR}/${FW_D_NAME}/${QCS6490_FW_SRC_PATH}/wpss.mdt
    # Build board-2.bin needed by WiFi
    ath11k-generate-ahb-board-2_json.sh ${UNPACKDIR}/${FW_D_NAME}/${QCS6490_FW_SRC_PATH} board-2.json
    python3 "${STAGING_BINDIR_NATIVE}/ath11k-bdencoder" -c board-2.json -o board-2.bin
}

do_install:append() {
    install -d ${D}${FW_QCOM_PATH}

    install -m 0644 ${B}/wpss.mbn ${D}${FW_QCOM_PATH}

    install -d ${D}${nonarch_base_libdir}/firmware/ath11k/WCN6750/hw1.0/
    install -m 0444 ${S}/board-2.bin ${D}${nonarch_base_libdir}/firmware/ath11k/WCN6750/hw1.0/board-2.bin

    install -d ${D}${sysconfdir}/
    install -m 0644 ${UNPACKDIR}/${LICENSE_FILE} ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}
    install -m 0644 ${UNPACKDIR}/${LICENSE_FILE_PDF} ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}.pdf
}

SPLIT_FIRMWARE_PACKAGES = "\
    linux-firmware-qcom-${FW_QCOM_NAME}-wifi \
"

inherit update-alternatives

ALTERNATIVE:${PN} += "wcn6750-hw10-board-2"
ALTERNATIVE_LINK_NAME[wcn6750-hw10-board-2] = "${nonarch_base_libdir}/firmware/ath11k/WCN6750/hw1.0/board-2.bin"
ALTERNATIVE_PRIORITY = "100"

FILES:linux-firmware-qcom-${FW_QCOM_NAME}-wifi = "${FW_QCOM_PATH}/wpss.mbn"
