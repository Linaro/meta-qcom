HOMEPAGE = "https://git.linaro.org/landing-teams/working/qualcomm/fastrpc.git"
SUMMARY = "Qualcomm FastRPC applications and library"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/fastrpc_apps_user.c;beginline=1;endline=29;md5=f94f3a7beba14ae2f59f817e9634f891"

SRCREV = "bc36c705c9b057ca880a423021d3c19f02edeadd"
SRC_URI = "\
    git://git.linaro.org/landing-teams/working/qualcomm/fastrpc.git;branch=automake;protocol=https \
    file://0001-apps_std_fopen_with_env-account-for-domain-kinds-whe.patch \
    file://adsprpcd.service \
    file://cdsprpcd.service \
    file://usr-lib-rfsa.service \
    file://mount-dsp.sh \
"

PV = "0.0+${SRCPV}"

S = "${WORKDIR}/git"

inherit autotools systemd

PACKAGES += "${PN}-systemd"
RRECOMMENDS_${PN} += "${PN}-systemd"

SYSTEMD_PACKAGES = "${PN} ${PN}-systemd"

SYSTEMD_SERVICE_${PN} = "usr-lib-rfsa.service"

SYSTEMD_SERVICE_${PN}-systemd = "adsprpcd.service cdsprpcd.service"
SYSTEMD_AUTO_ENABLE_${PN}-systemd = "disable"

do_install_append() {
    install -d ${D}${libdir}/rfsa

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/usr-lib-rfsa.service ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/adsprpcd.service ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/cdsprpcd.service ${D}${systemd_unitdir}/system

    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/mount-dsp.sh ${D}${sbindir}
}

FILES_${PN} += " \
    ${libdir}/rfsa \
    ${libdir}/libadsp_default_listener.so \
    ${libdir}/libcdsp_default_listener.so \
    ${libdir}/libadsprpc.so \
    ${libdir}/libcdsprpc.so \
"

FILES_${PN}-dev_remove = "${FILES_SOLIBSDEV}"

# We need to include lib*dsprpc.so into fastrpc for compatibility with Hexagon SDK
ERROR_QA_remove = "dev-so"
