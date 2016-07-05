require recipes-multimedia/gstreamer/gstreamer1.0-plugins.inc

SUMMARY = "QCOM V4l2 Plugins for the GStreamer multimedia framework 1.x "
HOMEPAGE = ""
BUGTRACKER = ""
SECTION = "multimedia"

LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d"
LICENSE = "GPLv2+ & LGPLv2.1+"

SRCREV_FORMAT = "plugin-common"

SRC_URI = " \
    git://git.linaro.org/landing-teams/working/qualcomm/pkg/gst-plugins-v4l2.git;protocol=https;branch=debian;name=plugin \
    git://anongit.freedesktop.org/gstreamer/common;name=common;branch=master;destsuffix=git/common \
    file://remove-git-from-autogen.patch \
"

SRCREV_plugin = "0d051f538fe00c8a79fcf12a05a6dac3a9af7dd7"
SRCREV_common = "12af105243823fc73581db4fd79a46f6d0268dc5"

COMPATIBLE_MACHINE = "(dragonboard-410c)"

S = "${WORKDIR}/git"

DEPENDS += "gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"

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
