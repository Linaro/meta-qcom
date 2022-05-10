DESCRIPTION = "QCOM Firmware for Qualcomm Robotics RB5 platform"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE.qcom.txt;md5=cbbe399f2c983ad51768f4561587f000"

SRC_URI = " \
    http://releases.linaro.org/96boards/rb5/qualcomm/firmware/RB5_firmware_${PV}.zip;subdir=${BP} \
"
SRC_URI[md5sum] = "d65ec09ba18dcafe291c870e0516c290"
SRC_URI[sha256sum] = "30e2c02be32de9f809b590f4fe76d9eb66d35f8c7d13b1f2850beb3d793192cc"

# From v2 to v4 the versioning has changed, so add epoch
# 20210118133815-v2
# 20210331-v4
PE = "1"

FW_QCOM_NAME = "sm8250"

require recipes-bsp/firmware/firmware-qcom.inc

do_install() {
    install -d ${D}${FW_QCOM_PATH}

    install -m 0444 ./08-dspso/dspso.bin ${D}${FW_QCOM_PATH}

    install -m 0444 ./30-slpi_split/slpi.mbn  ${D}${FW_QCOM_PATH}/
    install -m 0444 ./39-jsn/slpi*.jsn  ${D}${FW_QCOM_PATH}/

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE.qcom.txt ${D}${sysconfdir}/QCOM-LINUX-BOARD-SUPPORT-LICENSE-${PN}
}

SPLIT_FIRMWARE_PACKAGES = " \
    ${PN}-dspso \
    linux-firmware-qcom-${FW_QCOM_NAME}-sensors \
"
