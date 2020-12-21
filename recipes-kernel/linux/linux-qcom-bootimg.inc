QIMG_DEPLOYDIR = "${WORKDIR}/qcom_deploy-${PN}"

# Define INITRAMFS_IMAGE and set QCOM_BOOTIMG_BUNDLE_INITRAMFS to 1 to allow
# creating kernel+initramfs Android boot images. For example add the following
# lines to your conf/local.conf:
#
# QCOM_BOOTIMG_BUNDLE_INITRAMFS = "1"
# INITRAMFS_IMAGE = "initramfs-kerneltest-image"
#
QCOM_BOOTIMG_BUNDLE_INITRAMFS ?= ""

python __anonymous () {
    if d.getVar('QCOM_BOOTIMG_BUNDLE_INITRAMFS'):
        d.appendVarFlag('do_qcom_img_deploy', 'depends', ' ${INITRAMFS_IMAGE}:do_image_complete')
}

python do_qcom_img_deploy() {
    import shutil
    import subprocess

    subdir = d.getVar("KERNEL_DEPLOYSUBDIR")
    if subdir is not None:
        qcom_deploy_dir = os.path.join(d.getVar("QIMG_DEPLOYDIR"), subdir)
        image_dir = os.path.join(d.getVar("DEPLOY_DIR_IMAGE"), subdir)
    else:
        qcom_deploy_dir = d.getVar("QIMG_DEPLOYDIR")
        image_dir = d.getVar("DEPLOY_DIR_IMAGE")

    initrd = None
    if d.getVar("QCOM_BOOTIMG_BUNDLE_INITRAMFS"):
        baseinitrd = os.path.join(d.getVar("DEPLOY_DIR_IMAGE"), d.getVar("INITRAMFS_IMAGE_NAME"))
        for img in (".cpio.gz", ".cpio.lz4", ".cpio.lzo", ".cpio.lzma", ".cpio.xz", ".cpio"):
            if os.path.exists(baseinitrd + img):
                initrd = baseinitrd + img
                break
        if not initrd:
            bb.fatal("Could not find initramfs image %s for bundling" % d.getVar("INITRAMFS_IMAGE"))

    B = d.getVar("B")
    D = d.getVar("D")
    kernel_output_dir = d.getVar("KERNEL_OUTPUT_DIR")
    kernel_imagedest = d.getVar("KERNEL_IMAGEDEST")
    kernel = os.path.join(B, "kernel-dtb")
    definitrd = os.path.join(B, "initrd.img")
    mkbootimg = os.path.join(d.getVar("STAGING_BINDIR_NATIVE"), "skales", "mkbootimg")
    kernel_image_name = d.getVar("KERNEL_IMAGE_NAME")
    kernel_link_name = d.getVar("KERNEL_IMAGE_LINK_NAME")
    output_img =  os.path.join(qcom_deploy_dir, "boot-%s.img" % (kernel_link_name))
    output_sd_img =  os.path.join(qcom_deploy_dir, "boot-sd-%s.img" % (kernel_link_name))

    arch = d.getVar("ARCH")
    if arch is "arm":
        kernel_name = "zImage"
    elif arch is "arm64":
        kernel_name = "Image.gz"
    else:
        bb.fatal("Unuspported ARCH %s" % arch)

    if os.path.exists(output_img):
        os.unlink(output_img)
    if os.path.exists(output_sd_img):
        os.unlink(output_sd_img)

    with open(definitrd, "w") as f:
        f.write("This is not an initrd\n")

    for dtbf in d.getVar("KERNEL_DEVICETREE").split():
        dtb = os.path.basename(dtbf)
        dtb_name = dtb.rsplit('.', 1)[0]

        def getVarDTB(name):
            return d.getVarFlag(name, dtb_name) or d.getVar(name)

        def make_image(template, rootfs, initrd=definitrd):
            output = os.path.join(qcom_deploy_dir, template % (dtb_name, kernel_image_name))
            output_link =  os.path.join(qcom_deploy_dir, template % (dtb_name, kernel_link_name))
            subprocess.check_call([mkbootimg,
                "--kernel", kernel,
                "--ramdisk", initrd,
                "--output", output,
                "--pagesize", getVarDTB("QCOM_BOOTIMG_PAGE_SIZE"),
                "--base", getVarDTB("QCOM_BOOTIMG_KERNEL_BASE"),
                "--cmdline", "root=%s rw rootwait %s %s" % (rootfs, consoles, getVarDTB("KERNEL_CMDLINE_EXTRA") or "")])
            if os.path.exists(output_link):
                os.unlink(output_link)
            os.symlink(os.path.basename(output), output_link)
            return output

        consoles = ' '.join(map(lambda c: "console=%(tty)s,%(rate)sn8" % dict(zip(("rate", "tty"), c.split(';'))), getVarDTB("SERIAL_CONSOLES").split()))

        # prepare kernel image with appended dtb
        with open(kernel, 'wb') as wfd:
            with open(os.path.join(kernel_output_dir, kernel_name), 'rb') as rfd:
                shutil.copyfileobj(rfd, wfd)
            with open(os.path.join(D, kernel_imagedest, dtb), 'rb') as rfd:
                shutil.copyfileobj(rfd, wfd)

        rootfs = getVarDTB("QCOM_BOOTIMG_ROOTFS")
        if not rootfs or rootfs is "":
            bb.fatal("QCOM_BOOTIMG_ROOTFS is undefined")

        output = make_image("boot-%s-%s.img", rootfs)
        if not os.path.exists(output_img):
            os.symlink(os.path.basename(output), output_img)

        if initrd:
            make_image("boot-initramfs-%s-%s.img", rootfs, initrd)

        sd_rootfs = getVarDTB("SD_QCOM_BOOTIMG_ROOTFS")
        if sd_rootfs:
            output = make_image("boot-sd-%s-%s.img", sd_rootfs)
            if not os.path.exists(output_sd_img):
                os.symlink(os.path.basename(output), output_sd_img)

            if initrd:
                make_image("boot-sd-initramfs-%s-%s.img", sd_rootfs, initrd)
}

do_qcom_img_deploy[depends] += "skales-native:do_populate_sysroot"

addtask qcom_img_deploy after do_populate_sysroot do_packagedata bundle_initramfs before do_deploy

# Setup sstate, see deploy.bbclass
SSTATETASKS += "do_qcom_img_deploy"
do_qcom_img_deploy[sstate-inputdirs] = "${QIMG_DEPLOYDIR}"
do_qcom_img_deploy[sstate-outputdirs] = "${DEPLOY_DIR_IMAGE}"

python do_qcom_img_deploy_setscene () {
    sstate_setscene(d)
}
addtask do_qcom_img_deploy_setscene
do_qcom_img_deploy[dirs] = "${QIMG_DEPLOYDIR} ${B}"
do_qcom_img_deploy[cleandirs] = "${QIMG_DEPLOYDIR}"
do_qcom_img_deploy[stamp-extra-info] = "${MACHINE_ARCH}"
