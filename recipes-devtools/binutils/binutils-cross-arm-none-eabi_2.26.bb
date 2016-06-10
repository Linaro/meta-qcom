require recipes-devtools/binutils/binutils.inc
require recipes-devtools/binutils/binutils-${PV}.inc
require recipes-devtools/binutils/binutils-cross.inc

FILESEXTRAPATHS_prepend := "${COREBASE}/meta/recipes-devtools/binutils/binutils:"

PROVIDES = ""
PN = "binutils-cross-arm-none-eabi"
TARGET_ARCH = "arm"
TARGET_VENDOR = "-none"
TARGET_VENDOR_virtclass-multilib-lib32 = "-none"
TARGET_OS = "eabi"

