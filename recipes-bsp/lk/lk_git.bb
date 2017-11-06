DESCRIPTION = "Android Little Kernel bootloader"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5a1abdab641eec675725c843f43f03af"

SRC_URI = "git://${LK_GIT_REPO};branch=${SRCBRANCH}"
LK_GIT_REPO ??= "git.linaro.org/landing-teams/working/qualcomm/lk.git;protocol=http"
SRCBRANCH = "release/LA.BR.1.2.7-03810-8x16.0"
SRCREV = "86d35f50902134e53da520ed6e982556d32619a8"
PV = "1.2.7-03810+${SRCPV}"

COMPATIBLE_MACHINE = "(apq8016)"
MAKE_TARGET = ""
MAKE_ARGS = ""
MAKE_TARGET_apq8016 = "msm8916"
MAKE_ARGS_apq8016 = "EMMC_BOOT=1"

EXTRA_OEMAKE = "${MAKE_TARGET} ${MAKE_ARGS} TOOLCHAIN_PREFIX=arm-none-eabi- NOECHO="

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "virtual/bootloader"

S = "${WORKDIR}/git"

inherit deploy

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = "gcc-cross-arm-none-eabi gcc-runtime-arm-none-eabi binutils-cross-arm-none-eabi"

STAGING_BINDIR_TOOLCHAIN = "${STAGING_DIR_NATIVE}${bindir_native}/arm-none-eabi"
LD = "arm-none-eabi-ld ${TOOLCHAIN_OPTIONS}"

LK_BINARY ?= "emmc_appsboot-${PV}-${PR}.mbn"
LK_SYMLINK ?= "emmc_appsboot.mbn"

do_compile () {
    LIBGCC=`arm-none-eabi-gcc ${TOOLCHAIN_OPTIONS} -print-libgcc-file-name`
    oe_runmake LIBGCC="$LIBGCC"
}

do_deploy() {
    install -d ${DEPLOYDIR}
    install ${B}/build-msm8916/emmc_appsboot.mbn ${DEPLOYDIR}/${LK_BINARY}
    ln -sf ${LK_BINARY} ${DEPLOYDIR}/${LK_SYMLINK}
}

addtask deploy before do_build after do_compile
