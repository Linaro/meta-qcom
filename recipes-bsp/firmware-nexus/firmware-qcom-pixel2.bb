DESCRIPTION = "QCOM Firmware for Google Pixel 2 / 2XL"

FW_QCOM_NAME = "walleye"
FW_QCOM_SUBDIR = "msm8998/Google/${FW_QCOM_NAME}"
EXTRA_DEVICE_SUBDIR = "msm8998/Google/taimen"
AOSP_BUILD = "rp1a.201005.004.a1"
CHECKSUM_vendor = "2fdea26a"

SRC_URI[vendor.sha256sum] = "4ec6cf5dfd6616ae39cf61f95657662e4b17dd193b6ab30547ef016359cfc118"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a530"

require firmware-qcom-pixel.inc

do_install:append() {
    install -m 0644 ${B}/firmware/a540_gpmu.fw2 ${D}${FW_QCOM_PATH}
}
