SUMMARY = "Qualcomm boot requirements"
DESCRIPTION = "A set of packages required to find the rootfs on the generic Qualcomm board"

inherit packagegroup

# Recommend the packages as some of them might end up being built-in
# qcom-pon is not strictly required, but it would be good to handle events if something goes wrong
RRECOMMENDS:${PN} = " \
    kernel-module-phy-qcom-qmp \
    kernel-module-qcom-pon \
    kernel-module-qnoc-sm8250 \
    kernel-module-ufs-qcom \
"
