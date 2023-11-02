# meta-qcom

## Introduction

OpenEmbedded/Yocto Project layer for Qualcomm based platforms.

This layer depends on:

```
URI: https://github.com/openembedded/openembedded-core.git
layers: meta
branch: master
revision: HEAD
```

This layers has an optional dependency on meta-oe layer:

```
URI: https://github.com/openembedded/meta-openembedded.git
layers: meta-oe
branch: master
revision: HEAD
```

The dependency is optional, and not strictly required. When meta-oe is enabled
in the build (e.g. it is used in BBLAYERS) then additional recipes from
meta-qcom are added to the metadata. You can refer to meta-qcom/conf/layer.conf
for the implementation details.

## Device support

All contemporary boards are supported by a single qcom-armv8a machine. Please
use it instead of using the per-board configuration file. In order to enable
support for the particular device extend the qcom-armv8a.conf file .

## Contributing

If you want to contribute changes, you can send Github pull requests at
https://github.com/Linaro/meta-qcom/pulls.

You can discuss about this layer, on `#linaro` on Libera Chat IRC network.

## Reporting issues

Please report any issue on https://github.com/Linaro/meta-qcom/issues

## Maintainer(s)

Dmitry Baryshkov <dmitry.baryshkov@linaro.org>
