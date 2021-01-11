require recipes-graphics/mesa/mesa.inc

SRC_URI = "git://gitlab.freedesktop.org/mesa/mesa.git;protocol=https \
           file://0001-meson.build-check-for-all-linux-host_os-combinations.patch \
           file://0002-meson.build-make-TLS-ELF-optional.patch \
           file://0003-Allow-enable-DRI-without-DRI-drivers.patch \
           file://0004-Revert-mesa-Enable-asm-unconditionally-now-that-gen_.patch \
           file://0001-meson-misdetects-64bit-atomics-on-mips-clang.patch \
           "
LIC_FILES_CHKSUM = "file://docs/license.rst;md5=9aa1bc48c9826ad9fdb16661f6930496"

SRCREV = "eb2a4a7dee7c84cde44294f991ae731f88d19272"
#SRCREV_sm8250 = "${AUTOREV}"

PLATFORMS_remove = "drm surfaceless"
PACKAGECONFIG[osmesa] = "-Dosmesa=true,-Dosmesa=false"

S = "${WORKDIR}/git"
PV = "20.4-dev+git${SRCPV}"

# Do not select this version by default
DEFAULT_PREFERENCE = "-1"

# Add package to install require files to run tests for mesa
PACKAGES =+ "mesa-ci"
FILES_${PN}-ci = "${bindir}/deqp-runner.sh ${datadir}/mesa/deqp-*"
do_install_append () {
    install -d ${D}/${datadir}/mesa

    install -m 0644 ${S}/.gitlab-ci/deqp-default-skips.txt ${D}/${datadir}/mesa/
    for f in ${S}/.gitlab-ci/deqp-freedreno-*; do
        install -m 0644 $f ${D}/${datadir}/mesa/
    done

    install -d ${D}/${bindir}
    install -m 0755 ${S}/.gitlab-ci/deqp-runner.sh ${D}/${bindir}/
}
