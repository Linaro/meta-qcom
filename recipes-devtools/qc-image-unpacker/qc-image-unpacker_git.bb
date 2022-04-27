SUMMARY = "Android Qualcomm Image Unpacker"
HOMEPAGE = "https://github.com/anestisb/qc_image_unpacker"
SECTION = "devel"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=138532bb21858341808df2740a1d13bf"

SRC_URI = " \
    git://github.com/anestisb/qc_image_unpacker;protocol=https;branch=master\
    file://0001-Move-image-format-detection-to-separate-handlers.patch;patchdir=.. \
    file://0002-Add-support-for-bootldr-images.patch;patchdir=.. \
    file://0003-Do-not-let-dirname-tamper-with-inputFile.patch;patchdir=.. \
    file://0004-Fail-if-an-image-can-not-be-opened.patch;patchdir=.. \
"

SRCREV = "dbaf73822205753c9a7722b330f74673cad183a5"

PV = "0.2.0+${SRCPV}"
S = "${WORKDIR}/git/src"

DEPENDS = "zlib"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/qc_image_unpacker ${D}${bindir} 
}

BBCLASSEXTEND = "native nativesdk"
