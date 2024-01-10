SUMMARY = "Qualcomm linux kernel UKI creation"

DESCRIPTION = "Pack kernel image as a UKI (Unified Kernel Image) \
by combining UEFI stub from systemd-boot, the kernel Image, initramfs, \
optional dtb, osrelease info and other metadata like kernel cmdline."

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause-Clear;md5=7a434440b651f4a472ca93716d01033a"

COMPATIBLE_HOST = '(arm.*|aarch64.*)-(linux.*)'

inherit python3native image-artifact-names linux-kernel-base

DEPENDS = " systemd-boot-native python3-native python3-pefile-native \
            os-release systemd-boot virtual/kernel "

require conf/image-uefi.conf

KERNEL_VERSION = "${@get_kernelversion_file('${STAGING_KERNEL_BUILDDIR}')}"

do_configure[depends] += " \
    systemd-boot:do_deploy \
    virtual/kernel:do_deploy \
    "
do_configure[depends] += "${@ '${INITRAMFS_IMAGE}:do_image_complete' if d.getVar('INITRAMFS_IMAGE') else ''}"

do_compile() {
    # Construct the ukify command
    ukify_cmd=""

    # Ramdisk
    if [ -n "${INITRAMFS_IMAGE}" ]; then
        initrd=""
        for img in ${INITRAMFS_FSTYPES}; do
            if [ -e "${DEPLOY_DIR_IMAGE}/${INITRAMFS_IMAGE_NAME}.$img" ]; then
                initrd="${DEPLOY_DIR_IMAGE}/${INITRAMFS_IMAGE_NAME}.$img"
                break
            fi
        done
        [ -f $initrd ] && echo "Creating UKI with $initrd" || bbfatal "$initrd is not a valid initrd to create UKI."
        ukify_cmd="$ukify_cmd --initrd=$initrd"
    fi

    # Kernel Image
    # Note: systemd-boot can't handle compressed kernel image.
    kernel_image="${DEPLOY_DIR_IMAGE}/Image"
    [ -f $kernel_image ] && echo "Creating UKI with $kernel_image" || bbfatal "No valid kernel image to create UKI. Add 'Image' to KERNEL_IMAGETYPES."
    ukify_cmd="$ukify_cmd --linux=$kernel_image"

    # Kernel version
    ukify_cmd="$ukify_cmd --uname ${KERNEL_VERSION}"

    # Kernel cmdline
    if [ -n "${KERNEL_CMDLINE_EXTRA}" ]; then
        ukify_cmd="$ukify_cmd --cmdline='${KERNEL_CMDLINE_EXTRA}'"
    fi

    # Architecture
    ukify_cmd="$ukify_cmd --efi-arch ${EFI_ARCH}"

    # OS-release
    osrelease="${RECIPE_SYSROOT}${libdir}/os-release"
    ukify_cmd="$ukify_cmd --os-release @$osrelease"

    # Stub
    stub="${DEPLOY_DIR_IMAGE}/linux${EFI_ARCH}.efi.stub"
    [ -f $stub ] && echo "Creating UKI with $stub" || bbfatal "$stub is not a valid stub to create UKI."
    ukify_cmd="$ukify_cmd --stub $stub"

    # Output
    mkdir -p "${B}${EFI_UKI_PATH}"
    output="${B}${EFI_UKI_PATH}/${EFI_LINUX_IMG}"
    rm -f $output
    ukify_cmd="$ukify_cmd --output=$output"

    # Call ukify to generate uki.
    echo "ukify cmd:$ukify_cmd"
    ukify build $ukify_cmd
}

do_install() {
    install -Dm 0755 ${B}${EFI_UKI_PATH}/${EFI_LINUX_IMG} ${D}${EFI_UKI_PATH}/${EFI_LINUX_IMG}
}

FILES:${PN} = "${EFI_UKI_PATH}/${EFI_LINUX_IMG}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SKIP_RECIPE[linux-qcom-uki] ?= "${@bb.utils.contains('KERNEL_IMAGETYPES', 'Image', '', 'systemd-boot needs uncompressed kernel image. Add "Image" to KERNEL_IMAGETYPES.', d)}"
