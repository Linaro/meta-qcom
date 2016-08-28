require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-cross-canadian.inc

SUMMARY = "GNU cc and gcc C compilers (cross-canadian for arm-none-eabi target)"
PN = "gcc-cross-canadian-arm-none-eabi"

DEPENDS = "virtual/${HOST_PREFIX}gcc-crosssdk virtual/${HOST_PREFIX}binutils-crosssdk virtual/nativesdk-${HOST_PREFIX}libc-for-gcc nativesdk-gettext \
           gcc-cross-arm-none-eabi binutils-cross-canadian-arm-none-eabi"

GCCMULTILIB = ""

require gcc-arm-none-eabi.inc

MODIFYTOS = "0"

PROVIDES = "${PN}"

EXTRA_OEMAKE += "inhibit_libc=true"
