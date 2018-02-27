
LICENSE += "\
    & Firmware-qcom \
"

LIC_FILES_CHKSUM += "\
    file://LICENSE.qcom;md5=164e3362a538eb11d3ac51e8e134294b \
"

NO_GENERIC_LICENSE[Firmware-qcom] = "LICENSE.qcom"

PACKAGES =+ " \
             ${PN}-qcom-license \
             ${PN}-qcom-venus-1.8 \
             ${PN}-qcom-adreno-a3xx \
"

# For QCOM VPU/GPU
LICENSE_${PN}-qcom-license = "Firmware-qcom"
FILES_${PN}-qcom-license   = "${nonarch_base_libdir}/firmware/LICENSE.qcom ${nonarch_base_libdir}/firmware/qcom/NOTICE.txt"
FILES_${PN}-qcom-venus-1.8 = "${nonarch_base_libdir}/firmware/qcom/venus-1.8/*"
FILES_${PN}-qcom-adreno-a3xx = "${nonarch_base_libdir}/firmware/qcom/a300_*.fw ${nonarch_base_libdir}/firmware/a300_*.fw"
RDEPENDS_${PN}-qcom-venus-1.8 = "${PN}-qcom-license"
RDEPENDS_${PN}-qcom-adreno-a3xx = "${PN}-qcom-license"

# For other firmwares
# Maybe split out to separate packages when needed.
LICENSE_${PN} += " \
    & Firmware-qcom \
"
