DESCRIPTION = "Android Little Kernel bootloader"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5a1abdab641eec675725c843f43f03af"

SRC_URI = "git://${LK_GIT_REPO};branch=${SRCBRANCH}"
LK_GIT_REPO ??= "git.linaro.org/landing-teams/working/qualcomm/lk.git;protocol=http"
SRCBRANCH = "release/LA.BR.1.2.4-00310-8x16.0"
SRCREV = "2740fc8aeb78bb2e012f63f6d500f3133139c504"
PV = "1.2.4-00310+${SRCPV}"

COMPATIBLE_MACHINE = "(dragonboard-410c)"
COMPATIBLE_ARCH = "(arm.*)"
MAKE_TARGET = ""
MAKE_ARGS = ""
MAKE_TARGET_dragonboard-410c = "msm8916"
MAKE_ARGS_dragonboard-410c = "EMMC_BOOT=1"

EXTRA_OEMAKE = "${MAKE_TARGET} ${MAKE_ARGS} TOOLCHAIN_PREFIX=arm-none-eabi- NOECHO="

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = "gcc-cross-arm-none-eabi gcc-runtime-arm-none-eabi"

STAGING_BINDIR_TOOLCHAIN = "${STAGING_DIR_NATIVE}${bindir_native}/${TARGET_ARCH}-none-eabi"
LD = "${TARGET_ARCH}-none-eabi-ld ${TOOLCHAIN_OPTIONS}"

do_compile () {
    LIBGCC=`arm-none-eabi-gcc ${TOOLCHAIN_OPTIONS} -print-libgcc-file-name`
    oe_runmake LIBGCC="$LIBGCC"
}
