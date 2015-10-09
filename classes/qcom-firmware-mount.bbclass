qcom_mount_firmware() {
    mkdir -p ${IMAGE_ROOTFS}/lib/firmware
    echo "LABEL=qcom-firmware /lib/firmware ext4 defaults 0 0" >> ${IMAGE_ROOTFS}/etc/fstab
}

ROOTFS_POSTPROCESS_COMMAND += "qcom_mount_firmware ; "
