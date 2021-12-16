SUMMARY = "libqrtr-glib is a glib-based library to use and manage the QRTR bus."
DESCRIPTION = "libqrtr-glib is a glib-based library to use and manage the \
	       QRTR (Qualcomm IPC Router) bus"
HOMEPAGE = "https://gitlab.freedesktop.org/mobile-broadband/libqrtr-glib"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = " \
    file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c \
"
DEPENDS = "glib-2.0 glib-2.0-native"

inherit autotools pkgconfig bash-completion gobject-introspection

SRC_URI = "http://www.freedesktop.org/software/libqmi/${BPN}-${PV}.tar.xz"

SRC_URI[sha256sum] = "30d879b2ade6f8f461def3a677755db5c0238babf688d5c83c03b3e6abe35cee"

