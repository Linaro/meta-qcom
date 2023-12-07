
SRC_URI:append:qcom = " \
    file://0001-arm64-dts-qcom-qcm2290-temporarily-disable-cluster-i.patch \
    file://qca6390-driver/0001-dt-bindings-mfd-qcom-qca639x-add-binding-for-QCA639x.patch \
    file://qca6390-driver/0002-mfd-qca639x-add-support-for-QCA639x-powerup-sequence.patch \
    file://qca6390-driver/0003-mfd-qcom-qca639x-switch-to-platform-config-data.patch \
    file://qca6390-driver/0004-mfd-qcom-qca639x-change-qca639x-to-use-gpios-rather-.patch \
    file://qca6390-driver/0005-mfd-qcom-qca639x-Add-support-for-WCN6855.patch \
    file://qca6390-dts/0001-arm64-dts-qcom-qrb5165-rb5-add-qca639x-power-domain.patch \
    file://qca6390-dts/0002-arm64-dts-qcom-Add-Bluetooth-support-on-RB5.patch \
    file://qca6390-dts/0003-arm64-dtb-qcom-qrb5165-rb5-add-power-domain-to-pcie0.patch \
    file://generic-drivers/0001-FROMLIST-dma-heap-Add-proper-kref-handling-on-dma-bu.patch \
    file://generic-drivers/0002-FROMLIST-dma-heap-Provide-accessors-so-that-in-kerne.patch \
    file://qcm6490-drivers/0001-FROMGIT-phy-qcom-qmp-ufs-Add-Phy-Configuration-suppo.patch \
    file://qcm6490-drivers/0001-PENDING-clk-qcom-gcc-Enable-the-force-mem-core-for-U.patch \
    file://qcm6490-drivers/0001-PENDING-dt-bindings-clock-Add-qcom-adsp-skip-pll-pro.patch \
    file://qcm6490-drivers/0002-PENDING-clk-qcom-lpassaudiocc-Add-support-to-skip-PL.patch \
    file://qcm6490-dtsi/0001-FROMLIST-dt-bindings-arm-qcom-Add-QCM6490-Fairphone-.patch \
    file://qcm6490-dtsi/0002-FROMLIST-arm64-dts-qcom-Use-QCOM_SCM_VMID-defines-fo.patch \
    file://qcm6490-dtsi/0003-FROMLIST-arm64-dts-qcom-Add-qcm6490-dts-file.patch \
    file://qcm6490-dtsi/0001-FROMLIST-arm64-dts-qcom-sc7280-Add-UFS-nodes-for-sc7.patch \
    file://qcm6490-dtsi/0001-PENDING-arm64-dts-qcom-sc7280-Add-interconnect-paths.patch \
    file://qcm6490-dtsi/0001-PENDING-arm64-dts-qcm6490-Update-the-protected-clock.patch \
    file://qcm6490-dtsi/0001-PENDING-dt-bindings-pinctrl-qcom-sc7280-pinctrl-add-.patch \
    file://qcm6490-dtsi/0002-PENDING-arm64-dts-qcom-qcm6490-Add-gpio-reserved-ran.patch \
    file://qcm6490-board-dts/0001-FROMLIST-dt-bindings-arm-qcom-Add-QCM6490-IDP-board.patch \
    file://qcm6490-board-dts/0001-PENDING-dt-bindings-arm-qcom-Add-QCM6490-RB3-board.patch \
    file://qcm6490-board-dts/0002-PENDING-arm64-dts-qcom-Add-qcm6490-rb3-support.patch \
    file://qcm6490-board-dts/0001-PENDING-arm64-dts-qcom-qcm6490-Add-UFS-nodes-for-IDP.patch \
    file://qcm6490-board-dts/0002-PENDING-arm64-dts-qcom-Add-UFS-nodes-for-qcm6490-rb3.patch \
    file://workarounds/0001-QCLINUX-arm64-dts-qcom-Add-board-id-and-msm-id-for-Q.patch \
    file://workarounds/0002-QCLINUX-arm64-dts-qcom-Add-board-id-and-msm-id-for-q.patch \
    file://workarounds/0001-QCLINUX-arm64-dts-qcom-qcm6490-disable-sdhc1-for-ufs.patch \
    file://workarounds/0001-PENDING-arm64-dts-qcom-Remove-voltage-vote-support-f.patch \
    file://workarounds/0002-PENDING-arm64-dts-qcom-Remove-voltage-vote-support-f.patch \
    file://workarounds/0001-PENDING-arm64-dts-qcm6490-Remove-voltage-voting-for-.patch \
    file://workarounds/0002-PENDING-arm64-dts-qcm6490-rb3-Remove-voltage-voting-.patch \
"
