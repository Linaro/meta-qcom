HOMEPAGE = "https://git.codelinaro.org/linaro/qcomlt/fastrpc.git"
SUMMARY = "Qualcomm FastRPC applications and library"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/fastrpc_apps_user.c;beginline=1;endline=29;md5=f94f3a7beba14ae2f59f817e9634f891"

SRCREV = "5a8320c46df8c0dbefe71d97a8273f417e8721f3"
SRC_URI = "\
    git://git.codelinaro.org/linaro/qcomlt/fastrpc.git;branch=automake;protocol=https \
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
RRECOMMENDS:${PN} += "${PN}-systemd"

SYSTEMD_PACKAGES = "${PN} ${PN}-systemd"

SYSTEMD_SERVICE:${PN} = "usr-lib-rfsa.service"

SYSTEMD_SERVICE:${PN}-systemd = "adsprpcd.service cdsprpcd.service"
SYSTEMD_AUTO_ENABLE:${PN}-systemd = "disable"

do_install:append() {
    install -d ${D}${libdir}/rfsa

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/usr-lib-rfsa.service ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/adsprpcd.service ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/cdsprpcd.service ${D}${systemd_unitdir}/system

    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/mount-dsp.sh ${D}${sbindir}
}

FILES:${PN} += " \
    ${libdir}/rfsa \
    ${libdir}/libadsp_default_listener.so \
    ${libdir}/libcdsp_default_listener.so \
    ${libdir}/libadsprpc.so \
    ${libdir}/libcdsprpc.so \
"

FILES:${PN}-dev:remove = "${FILES_SOLIBSDEV}"

# We need to include lib*dsprpc.so into fastrpc for compatibility with Hexagon SDK
ERROR_QA:remove = "dev-so"
