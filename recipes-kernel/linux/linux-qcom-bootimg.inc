DEPENDS += "skales-native"

QCOM_BOOTIMG_ROOTFS ?= "undefined"
SD_QCOM_BOOTIMG_ROOTFS ?= "undefined"

# set output file names
KERNEL_CMDLINE = "root=${1} rw rootwait console=${ttydev},${baudrate}n8"
KERNEL_CMDLINE_append_dragonboard-845c = " clk_ignore_unused pd_ignore_unused"
KERNEL_CMDLINE_append_qrb5165-rb5 = " pcie_pme=nomsi"

# param ${1} partition where rootfs is located
# param ${2} output boot image file name
# param ${3} kernel imagename
priv_make_image() {
    ${STAGING_BINDIR_NATIVE}/skales/mkbootimg --kernel ${3} \
              --ramdisk ${B}/initrd.img \
              --output ${DEPLOYDIR}/${2}.img \
              --pagesize ${QCOM_BOOTIMG_PAGE_SIZE} \
              --base ${QCOM_BOOTIMG_KERNEL_BASE} \
              --cmdline "${KERNEL_CMDLINE}"
}

do_deploy_append() {

    tmp="${SERIAL_CONSOLES}"
    baudrate=`echo $tmp | sed 's/\;.*//'`
    ttydev=`echo $tmp | sed -e 's/^[0-9]*\;//' -e 's/\s.*//' -e 's/\;.*//'`

    # mkbootimg requires an initrd file, make fake one that will be ignored
    # during boot
    echo "This is not an initrd" > ${B}/initrd.img

    # don't build bootimg if rootfs partition is not defined
    if [ "${QCOM_BOOTIMG_ROOTFS}" = "undefined" ]; then
        bbfatal "Rootfs partition must be defined"
    fi

    for dtbf in ${KERNEL_DEVICETREE}; do
	dtb=`normalize_dtb "$dtbf"`
	dtb_ext=${dtb##*.}
	dtb_base_name=`basename $dtb .$dtb_ext`
	priv_make_image ${QCOM_BOOTIMG_ROOTFS} boot-$dtb_base_name-${KERNEL_IMAGE_NAME} ${deployDir}/Image.gz-$dtb_base_name-${KERNEL_DTB_NAME}.$dtb_ext.bin
	ln -sf boot-${dtb_base_name}-${KERNEL_IMAGE_NAME}.img ${DEPLOYDIR}/boot-${dtb_base_name}-${KERNEL_IMAGE_LINK_NAME}.img
	if [ ! -h ${DEPLOYDIR}/boot-${KERNEL_IMAGE_LINK_NAME}.img ]; then
	    ln -sf boot-${dtb_base_name}-${KERNEL_IMAGE_NAME}.img ${DEPLOYDIR}/boot-${KERNEL_IMAGE_LINK_NAME}.img
	fi

	# build sd boot image only for machines supporting it.
	if [ "${SD_QCOM_BOOTIMG_ROOTFS}" != "undefined" ]; then
	    priv_make_image ${SD_QCOM_BOOTIMG_ROOTFS} boot-sd-$dtb_base_name-${KERNEL_IMAGE_NAME} ${deployDir}/Image.gz-$dtb_base_name-${KERNEL_DTB_NAME}.$dtb_ext.bin
	    ln -sf boot-sd-${dtb_base_name}-${KERNEL_IMAGE_NAME}.img ${DEPLOYDIR}/boot-sd-${dtb_base_name}-${KERNEL_IMAGE_LINK_NAME}.img
	    if [ ! -h ${DEPLOYDIR}/boot-sd-${KERNEL_IMAGE_LINK_NAME}.img ]; then
		ln -sf boot-sd-${dtb_base_name}-${KERNEL_IMAGE_NAME}.img ${DEPLOYDIR}/boot-sd-${KERNEL_IMAGE_LINK_NAME}.img
	    fi
	fi
    done
}
