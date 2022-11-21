DESCRIPTION = "QCOM Firmware for Google Pixel 3a / 3a XL"

FW_QCOM_NAME = "sargo"
FW_QCOM_SUBDIR = "sdm670/Google/${FW_QCOM_NAME}"
EXTRA_DEVICE_SUBDIR = "sdm670/Google/bonito"
AOSP_BUILD = "sp2a.220505.008"
CHECKSUM_vendor = "772e1993"

SRC_URI[vendor.sha256sum] = "702c4563207f77eefa7822ffbfaf0cc8a33059140f417b2deda1844ae4bb097c"

RDEPENDS:${PN} += "linux-firmware-qcom-adreno-a630"

require firmware-qcom-pixel.inc
