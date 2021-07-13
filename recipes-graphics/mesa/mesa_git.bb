require recipes-graphics/mesa/mesa.inc

SRC_URI = "git://gitlab.freedesktop.org/mesa/mesa.git;protocol=https;branch=main \
           file://0001-meson.build-check-for-all-linux-host_os-combinations.patch \
           file://0002-meson.build-make-TLS-ELF-optional.patch \
           file://0001-meson-misdetects-64bit-atomics-on-mips-clang.patch \
           "
LIC_FILES_CHKSUM = "file://docs/license.rst;md5=17a4ea65de7a9ab42437f3131e616a7f"

SRCREV = "${@oe.utils.conditional("MESA_DEV", "1", "${AUTOREV}", "26677008b9a7c0ef82f2a7f4b479d3cb06097c66", d)}"
DEFAULT_PREFERENCE = "${@oe.utils.conditional("MESA_DEV", "1", "1", "-1", d)}"

PLATFORMS_remove = "drm surfaceless"
PACKAGECONFIG[osmesa] = "-Dosmesa=true,-Dosmesa=false"
DRIDRIVERS_remove = "swrast"
DRIDRIVERS_class-native = "auto"
DRIDRIVERS_class-nativesdk = "auto"

S = "${WORKDIR}/git"
PV = "2x.x-dev+git${SRCPV}"
ERROR_QA_remove = "version-going-backwards"

# Add package to install require files to run tests for mesa
PACKAGES =+ "mesa-ci"
FILES_${PN}-ci = "${bindir}/deqp-runner.sh ${datadir}/mesa/deqp-*"
do_install_append () {
    install -d ${D}/${datadir}/mesa

    install -m 0644 ${S}/.gitlab-ci/deqp-all-skips.txt ${D}/${datadir}/mesa/
    for f in ${S}/src/freedreno/ci/deqp-freedreno-*; do
        install -m 0644 $f ${D}/${datadir}/mesa/
    done

    install -d ${D}/${bindir}
    install -m 0755 ${S}/.gitlab-ci/deqp-runner.sh ${D}/${bindir}/
}
