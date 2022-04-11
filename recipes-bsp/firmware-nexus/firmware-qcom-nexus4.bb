DESCRIPTION = "QCOM Firmware for LGE Google Nexus 4"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://license.txt;md5=0d238870f50c84250a14191d17aaf1d5"

FW_QCOM_NAME = "mako"
AOSP_BUILD = "lmy48t"
CHECKSUM_qcom = "8c489b7e"

SRC_URI[qcom.sha256sum] = "d87a4e4958c5750818fd525c32c7b6a659cd8da7e0dd46d92c16ad8c5aa1bf68"

require recipes-bsp/firmware-nexus/firmware-qcom-nexus.inc

SRC_URI += "git://android.googlesource.com/device/lge/${FW_QCOM_NAME};protocol=https;branch=master;name=aosp"
SRCREV_aosp = "33f0114334f9304dd69a8dfac24bc7f3d195d3be"
PV:append = "+git${SRCPV}"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a3xx"

do_install:append() {
    install -d ${D}${FW_QCOM_PATH}
    install -m 0644 ${WORKDIR}/git/WCNSS_cfg.dat ${D}${FW_QCOM_PATH}
    install -m 0644 ${WORKDIR}/git/WCNSS_qcom_wlan_nv.bin ${D}${FW_QCOM_PATH}
}
