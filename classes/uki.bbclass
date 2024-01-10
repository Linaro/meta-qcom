# This bbclass repacks kernel image as a UKI (Unified Kernel Image)
# Composed by
#   - an UEFI stub, from systemd-boot
#   - the kernel Image
#   - an initramfs
#   - other metadata like kernel cmdline

DEPENDS:append = " \
            systemd-boot-native \
            python3-native \
            python3-pefile-native \
            "

require conf/image-uefi.conf

inherit python3native

do_install[depends] += " \
    systemd-boot:do_deploy \
    "
do_install[depends] += "${@ '${INITRAMFS_IMAGE}:do_image_complete' if d.getVar('INITRAMFS_IMAGE') else ''}"
do_uki[dirs] = "${B}"
do_install[postfuncs] += "do_uki"

python do_uki() {
    import glob
    import subprocess

    # Construct the ukify command
    ukify_cmd = ("ukify build")

    deploy_dir_image = d.getVar('DEPLOY_DIR_IMAGE')

    # Ramdisk
    if d.getVar('INITRAMFS_IMAGE'):
        initrd_image = d.getVar('INITRAMFS_IMAGE') + "-" + d.getVar('MACHINE')
        baseinitrd = os.path.join(d.getVar('INITRAMFS_DEPLOY_DIR_IMAGE'), initrd_image)
        for img in (".cpio.gz", ".cpio.lz4", ".cpio.lzo", ".cpio.lzma", ".cpio.xz", ".cpio"):
            if os.path.exists(baseinitrd + img):
                initrd = baseinitrd + img
                break
        if not initrd:
            bb.fatal("initrd= must be specified to create unified kernel image.")
        ukify_cmd += " --initrd=%s" % initrd

    # Kernel Image.
    # Note: systemd-boot can't handle compressed kernel image.
    kernel_image = d.getVar('B') + "/" + d.getVar('KERNEL_OUTPUT_DIR') + "/Image"
    kernel_version = d.getVar('KERNEL_VERSION')
    if not os.path.exists(kernel_image):
        bb.fatal("linux= must be specified to create unified kernel image.")
    ukify_cmd += " --linux=%s --uname %s" % (kernel_image, kernel_version)

    # Kernel cmdline
    cmdline = "%s" %(d.getVar('KERNEL_CMDLINE_EXTRA'))
    ukify_cmd += " --cmdline='%s'" % (cmdline)

    # Architecture
    target_arch = d.getVar('EFI_ARCH')
    ukify_cmd += " --efi-arch %s" % target_arch

    # Stub
    stub = "%s/linux%s.efi.stub" % (deploy_dir_image, target_arch)
    if not os.path.exists(stub):
        bb.fatal("stub must be specified to create unified kernel image %s" %stub)
    ukify_cmd += " --stub %s" % stub

    # Custom UKI name
    output_dir = d.getVar('D') + "/" +  d.getVar('EFI_UKI_PATH')
    os.makedirs(output_dir, exist_ok=True)
    output = output_dir + "/" + d.getVar('EFI_LINUX_IMG')
    ukify_cmd += " --output=%s" % output

    # Set env to determine where bitbake should look for dynamic libraries
    env = os.environ.copy() # get the env variables
    env['LD_LIBRARY_PATH'] = d.expand("${RECIPE_SYSROOT_NATIVE}/usr/lib/systemd:${LD_LIBRARY_PATH}")

    # Run the ukify command
    subprocess.check_call(ukify_cmd, env=env, shell=True)
}

# Support uki as a package
python () {
    if not bb.data.inherits_class('nopackages', d):
        d.appendVar("PACKAGES", " ${KERNEL_PACKAGE_NAME}-uki")
}

FILES:${KERNEL_PACKAGE_NAME}-uki = " \
    /${EFI_UKI_PATH}/${EFI_LINUX_IMG} \
"
