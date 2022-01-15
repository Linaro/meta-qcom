require recipes-kernel/linux/linux-qcom-bootimg.inc

KBUILD_DEFCONFIG:qcom = "defconfig"
KBUILD_DEFCONFIG:qcom:arm = "qcom_defconfig"
