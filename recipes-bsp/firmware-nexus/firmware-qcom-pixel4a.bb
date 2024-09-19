DESCRIPTION = "QCOM Firmware for Google Pixel 4a"

FW_QCOM_NAME = "sunfish"
FW_QCOM_SUBDIR = "sdm730/Google/${FW_QCOM_NAME}"
AOSP_BUILD = "tq3a.230805.001.s1"
CHECKSUM_vendor = "2a7bf157"

SRC_URI[vendor.sha256sum] = "f82c4214524f0d1f85e9ad7b2a23ddaed0b402cabc5b01533a61dcd1adb7d80f"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a630"

VENDOR_IMG_SPARSE = "0"
require firmware-qcom-pixel.inc
