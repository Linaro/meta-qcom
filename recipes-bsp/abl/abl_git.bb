LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://QcomModulePkg/Application/LinuxLoader/LinuxLoader.c;beginline=7;endline=29;md5=7c6dc89af6257c35a8b33fca46b1018e"

SRC_URI = " \
    git://git.linaro.org/landing-teams/working/qualcomm/abl.git;name=abl;protocol=https;branch=${ABL_BRANCH} \
    git://git.codelinaro.org/clo/la/platform/prebuilts/clang/host/linux-x86;name=clang;subdir=clang;protocol=https;nobranch=1 \
"

ABL_BRANCH = "release/LU.UM.1.2.1.r1-23200-QRB5165.0"

# release/LU.UM.1.2.1.r1-23200-QRB5165.0
SRCREV_abl = "08d45c55c98abe9ed553de96398c6fa1624e27fd"

# LA.UM.7.9.1.r1-00300-QCS610.0
SRCREV_clang = "602d656c20004480b26aa539f93d266303bafdf7"

SRCREV_FORMAT = "abl_clang"
PV = "0.0+git${SRCPV}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

# use include here to let parser skip it if meta-python2 layer is not enabled
include classes/pythonnative.bbclass

inherit deploy

# ccache confuses build system
CCACHE_DISABLE = "1"

do_configure() {
}

do_compile() {
    unset CC
    unset CXX

    make -C BaseTools CC="${BUILD_CC}" CXX="${BUILD_CXX}"

    make all \
        BOOTLOADER_OUT=out/edk2 \
        BUILD_SYSTEM_ROOT_IMAGE=0 \
        VERIFIED_BOOT=0 \
        VERIFIED_BOOT_2=0 \
        VERIFIED_BOOT_LE=0 \
        USER_BUILD_VARIANT=0 \
        DISABLE_PARALLEL_DOWNLOAD_FLASH=1 \
        ABL_USE_SDLLVM=false \
        ABL_SAFESTACK=false \
        AB_RETRYCOUNT_DISABLE=1 \
        CLANG_BIN=${WORKDIR}/clang/clang-4691093/bin/ \
        CLANG_PREFIX="${HOST_PREFIX}" \
        TARGET_ARCHITECTURE=AARCH64 \
        BOARD_BOOTLOADER_PRODUCT_NAME="SuperEDK2k"
}

do_deploy() {
    install -D -p -m644 ${S}/abl.elf ${DEPLOYDIR}/abl-unsigned.elf
}

addtask deploy before do_build after do_compile

