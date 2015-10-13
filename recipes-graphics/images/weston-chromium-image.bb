SUMMARY = "Basic Wayland image with Chromium/Wayland"

IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs"

LICENSE = "MIT"

inherit core-image distro_features_check extrausers

# let's make sure we have a good image..
REQUIRED_DISTRO_FEATURES = "wayland pam systemd"

CORE_IMAGE_BASE_INSTALL += "weston weston-examples clutter-1.0-examples \
                            e2fsprogs-resize2fs chromium kernel-modules connman"

EXTRA_USERS_PARAMS = "\
useradd -p '' linaro; \
usermod -a -G weston-launch linaro; \
"
