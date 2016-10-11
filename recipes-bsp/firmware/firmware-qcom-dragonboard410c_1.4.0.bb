DESCRIPTION = "QCOM Firmware for DragonBoard 410c"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=003cae816e20ae44589f8f7cc022cb54"

SRC_URI = "http://developer.qualcomm.com/download/db410c/firmware-410c-${PV}.bin;qcom-eula=true"
SRC_URI[md5sum] = "be80a375473a9308d8b4b47c4d8ff811"
SRC_URI[sha256sum] = "822d2f8506d9657dbce6aa2bfce81ccbf97dcfc40831b70703b14b3f296fa4c0"

DEPENDS += "mtools-native"
do_unpack[depends] += "bc-native:do_populate_sysroot"

COMPATIBLE_MACHINE = "(dragonboard-410c)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/linux-board-support-package-v1.4"

python qcom_bin_do_unpack() {
    src_uri = (d.getVar('SRC_URI', True) or "").split()
    if len(src_uri) == 0:
        return

    localdata = bb.data.createCopy(d)
    bb.data.update_data(localdata)

    rootdir = localdata.getVar('WORKDIR', True)
    fetcher = bb.fetch2.Fetch(src_uri, localdata)

    for url in fetcher.ud.values():
        save_cwd = os.getcwd()
        # Check for supported fetchers
        if url.type in ['http', 'https', 'ftp', 'file']:
            if url.parm.get('qcom-eula', False):
                # If download has failed, do nothing
                if not os.path.exists(url.localpath):
                    bb.debug(1, "Exiting as '%s' cannot be found" % url.basename)
                    return

                # Change to the working directory
                bb.note("Handling file '%s' as a Qualcomm's EULA binary." % url.basename)
                save_cwd = os.getcwd()
                os.chdir(rootdir)

                cmd = "sh %s --auto-accept --force" % (url.localpath)
                bb.fetch2.runfetchcmd(cmd, d, quiet=True)

    # Return to the previous directory
    os.chdir(save_cwd)
}

python do_unpack() {
    eula = d.getVar('ACCEPT_EULA_'+d.getVar('MACHINE', True), True)
    eula_file = d.getVar('QCOM_EULA_FILE', True)
    pkg = d.getVar('PN', True)
    if eula == None:
        bb.fatal("To use '%s' you need to accept the EULA at '%s'. "
                 "Please read it and in case you accept it, write: "
                 "ACCEPT_EULA_dragonboard-410c = \"1\" in your local.conf." % (pkg, eula_file))
    elif eula == '0':
        bb.fatal("To use '%s' you need to accept the EULA." % pkg)
    else:
        bb.note("EULA has been accepted for '%s'" % pkg)

    # The binary unpack needs to be done first so 'S' is valid
    bb.build.exec_func('qcom_bin_do_unpack', d)

    try:
        bb.build.exec_func('base_do_unpack', d)
    except:
        raise
}

do_compile() {
	:
}

do_install() {
    install -d  ${D}/lib/firmware/
    rm -f ./proprietary-linux/firmware.tar
    cp -r ./proprietary-linux/* ${D}/lib/firmware/

    MTOOLS_SKIP_CHECK=1 mcopy -i ./bootloaders-linux/NON-HLOS.bin \
    ::image/modem.* ::image/mba.mbn ${D}/lib/firmware/

    install -d ${D}${sysconfdir}/
    install -m 0644 LICENSE ${D}${sysconfdir}/license.txt
}

FILES_${PN} += "/lib/firmware/*"
INSANE_SKIP_${PN} += "arch"
