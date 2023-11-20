
SRC_URI:append:qcom = " \
    file://0001-arm64-dts-qcom-qrb2210-rb1-Swap-UART-index.patch \
    file://0001-arm64-dts-qcom-qcm2290-temporarily-disable-cluster-i.patch \
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
"
