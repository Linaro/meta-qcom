SUMMARY = "Resize rootfs to fill the complete partition"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

# Only a postinst is needed, no actual files inside the resulting package
ALLOW_EMPTY_${PN} = "1"

pkg_postinst_${PN} () {
if [ x"$D" = "x" ]; then
    # On target
    resize2fs  /dev/disk/by-partlabel/rootfs
else
    exit 1
fi
}

RDEPENDS_${PN} = "e2fsprogs-resize2fs"
