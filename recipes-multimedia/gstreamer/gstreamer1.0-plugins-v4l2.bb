require recipes-multimedia/gstreamer/gstreamer1.0-plugins.inc

SUMMARY = "QCOM V4l2 Plugins for the GStreamer multimedia framework 1.x "
HOMEPAGE = ""
BUGTRACKER = ""
SECTION = "multimedia"

LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d"
LICENSE = "GPLv2+ & LGPLv2.1+"

SRC_URI = " git://git.linaro.org/people/nicolas.dechesne/gst-plugins-v4l2.git;protocol=https;branch=debian "
SRCREV = "4bd1c91953649cb8c5f4396e2156477cf48f4362"

S = "${WORKDIR}/git"

DEPENDS += "gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"

PR = "r1"

inherit gettext

# For using v4l2dec gstreamer plugins with MSM_VIDC driver
# you MUST force the option "--without-libv4l"
PACKAGECONFIG ??= ""

PACKAGECONFIG[v4l2] = "--with-libv4l2,--without-libv4l2,v4l-utils"

EXTRA_OECONF += " \
    ${GSTREAMER_1_0_ORC} \
"

FILES_${PN} += " ${libdir}/gstreamer-1.0/*.so "

do_configure_prepend() {
    srcdir=${S} NOCONFIGURE=1 ${S}/autogen.sh
}

