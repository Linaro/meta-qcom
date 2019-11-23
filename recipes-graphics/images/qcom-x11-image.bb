SUMMARY = "Basic X11 graphics image"

IMAGE_FEATURES += "splash package-management debug-tweaks ssh-server-openssh hwcodecs x11 tools-debug"

LICENSE = "MIT"

inherit core-image features_check extrausers

# let's make sure we have a good image..
REQUIRED_DISTRO_FEATURES = "x11"

# make sure we boot to desktop
# by default and without x11-base in IMAGE_FEATURES we default to multi-user.target
SYSTEMD_DEFAULT_TARGET = "graphical.target"

CORE_IMAGE_BASE_INSTALL += " \
    alsa-utils-aplay \
    coreutils \
    glmark2 \
    gptfdisk \
    gstreamer1.0-plugins-bad-meta \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    gtkperf \
    kernel-modules \
    kmscube \
    mesa-demos \
    openbox \
    rsync \
"
