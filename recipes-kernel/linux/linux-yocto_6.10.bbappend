
SRC_URI:append:qcom = " \
    file://qca6390-driver/0001-dt-bindings-mfd-qcom-qca639x-add-binding-for-QCA639x.patch \
    file://qca6390-driver/0002-mfd-qca639x-add-support-for-QCA639x-powerup-sequence.patch \
    file://qca6390-driver/0003-mfd-qcom-qca639x-switch-to-platform-config-data.patch \
    file://qca6390-driver/0004-mfd-qcom-qca639x-change-qca639x-to-use-gpios-rather-.patch \
    file://qca6390-driver/0005-mfd-qcom-qca639x-Add-support-for-WCN6855.patch \
    file://qca6390-dts/0001-arm64-dts-qcom-qrb5165-rb5-add-qca639x-power-domain.patch \
    file://qca6390-dts/0003-arm64-dtb-qcom-qrb5165-rb5-add-power-domain-to-pcie0.patch \
    file://generic-drivers/0001-FROMLIST-dma-heap-Add-proper-kref-handling-on-dma-bu.patch \
    file://generic-drivers/0002-FROMLIST-dma-heap-Provide-accessors-so-that-in-kerne.patch \
    file://qcm6490-board-dts/0001-FROMLIST-arm64-dts-qcom-qcm6490-idp-Update-protected.patch \
    file://qcm6490-board-dts/0003-BACKPORT-FROMLIST-arm64-dts-qcom-qcs6490-rb3gen2-Upd.patch \
    file://qcm6490-board-dts/0001-PENDING-arm64-dts-qcom-qcm6490-Add-UFS-nodes-for-IDP.patch \
    file://qcm6490-board-dts/0002-PENDING-arm64-dts-qcom-Add-UFS-nodes-for-qcs6490-rb3.patch \
    file://workarounds/0001-QCLINUX-arm64-dts-qcom-qcm6490-disable-sdhc1-for-ufs.patch \
    file://workarounds/0001-PENDING-arm64-dts-qcom-Remove-voltage-vote-support-f.patch \
    file://workarounds/0002-PENDING-arm64-dts-qcom-Remove-voltage-vote-support-f.patch \
    file://workarounds/0001-PENDING-arm64-dts-qcm6490-Remove-voltage-voting-for-.patch \
    file://workarounds/0002-PENDING-arm64-dts-qcs6490-rb3-Remove-voltage-voting-.patch \
"
