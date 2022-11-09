LICENSE = "Proprietary"
LIC_FILES_CHKSUM ?= "file://license.txt;md5=63a79fa5adc049f2e411b1f700cf0f19"

VENDOR ?= "google_devices"
EXTRA_DEVICE_NAME ??= ""

SRC_URI = "https://dl.google.com/dl/android/aosp/${VENDOR}-${FW_QCOM_NAME}-${AOSP_BUILD}-${CHECKSUM_vendor}.tgz;name=vendor"

PV = "${AOSP_BUILD}"

require recipes-bsp/firmware/firmware-qcom.inc

DEPENDS += "pil-squasher-native rust-android-sparse-native e2fsprogs-native qc-image-unpacker-native mtools-native"

# extract the license file
do_extract() {
    head -n 280 ${WORKDIR}/extract-${VENDOR}-${FW_QCOM_NAME}.sh | tail -n +16 > ${S}/license.txt
    tail -n +315 ${WORKDIR}/extract-${VENDOR}-${FW_QCOM_NAME}.sh | tar xzfv - -C ${S}
    simg2img ${S}/vendor/${VENDOR}/${FW_QCOM_NAME}/proprietary/vendor.img ${B}/vendor.img

    # FIXME: also extract fastrpc shell
    mkdir -p ${B}/firmware
    debugfs ${B}/vendor.img -R 'ls -p /firmware' | \
        grep '^/[0-9]*/100' | cut -d/ -f6 > ${B}/firmware/fw.lst
    debugfs ${B}/vendor.img -R 'ls -p /firmware' | \
        grep '^/[0-9]*/100' | cut -d/ -f6 | \
        while read name ; do echo "dump /firmware/$name ${B}/firmware/$name" ; done | \
        debugfs ${B}/vendor.img

    radio="${S}/vendor/${VENDOR}/${FW_QCOM_NAME}/proprietary/radio.img"
    if [ -r "${radio}" ] ; then
        rm -rf "${radio}_images"
        qc_image_unpacker -i "${radio}" -f || exit 1

        if ! [ -r "${radio}_images"/modem ] ; then
            echo "modem image not found"
            exit 1
        fi

        mkdir -p ${B}/firmware
        mcopy -i "${radio}_images"/modem ::/image/* ${B}/firmware/
        mdir -i "${radio}_images"/modem ::/image
    fi
}
addtask extract after do_unpack before do_patch
do_extract[deptask] = "do_populate_sysroot"

do_compile() {
    for fw in ${B}/firmware/*.mdt ; do
        pil-squasher ${B}/`basename $fw mdt`mbn $fw || exit 1
    done
}

do_install() {
    install -d ${D}${FW_QCOM_PATH}
    for fw in adsp cdsp cpe ipa_fws modem slpi venus ; do
        ls ${B}/$fw*.mbn && install -m 0644 ${B}/$fw*.mbn ${D}${FW_QCOM_PATH}
    done

    ls ${B}/firmware/cpp*.fw && install -m 0644 ${B}/firmware/cpp*.fw ${D}${FW_QCOM_PATH}
    ls ${B}/firmware/leia*.fw && install -m 0644 ${B}/firmware/leia*.fw ${D}${FW_QCOM_PATH}
    ls ${B}/firmware/*.jsn && install -m 0644 ${B}/firmware/*.jsn ${D}${FW_QCOM_PATH}

    install -m 0644 ${B}/firmware/a[0-9]*.fw* ${D}${FW_QCOM_PATH}
    ls ${B}/a[0-9]*.mbn && install -m 0644 ${B}/a[0-9]*.mbn ${D}${FW_QCOM_PATH}

    install -m 0644 license.txt ${D}${FW_QCOM_PATH}

    # Remove duplicates
    rm -f ${D}${FW_QCOM_PATH}/leia_pfp_470.fw
    rm -f ${D}${FW_QCOM_PATH}/leia_pm4_470.fw
    rm -f ${D}${FW_QCOM_PATH}/a420_pfp.fw
    rm -f ${D}${FW_QCOM_PATH}/a420_pm4.fw
    rm -f ${D}${FW_QCOM_PATH}/a530v3_gpmu.fw2

    [ -z "${EXTRA_DEVICE_NAME}" ] || ln -sr ${D}${FW_QCOM_PATH} ${D}${FW_QCOM_BASE_PATH}/${EXTRA_DEVICE_NAME}
}
