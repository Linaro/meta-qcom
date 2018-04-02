# meta-qcom

## Introduction

OpenEmbedded/Yocto Project layer for Qualcomm based platforms.

This layer depends on:

```
URI: git://github.com/openembedded/oe-core.git
layers: meta
branch: master
revision: HEAD
```

This layers has an optional dependency on meta-oe layer:

```
URI: git://github.com/openembedded/meta-openembedded.git
layers: meta-oe
branch: master
revision: HEAD
```

The dependency is optional, and not strictly required. When meta-oe is enabled
in the build (e.g. it is used in BBLAYERS) then additional recipes from
meta-qcom are added to the metadata. You can refer to meta-qcom/conf/layer.conf
for the implementation details.

## Contributing

If you want to contribute changes, you can send Github pull requests at
https://github.com/ndechesne/meta-qcom/pulls.

Alternatively you can send patches to openembedded@lists.linaro.org, in which
case, please: 

* When creating patches, please use something like:

`git format-patch -s --subject-prefix='meta-qcom][PATCH' origin`

* When sending patches, please use something like:

`git send-email --to openembedded@lists.linaro.org <generated patch>`

You can discuss about this layer, on `#linaro` on FreeNode IRC network.

## Reporting issues

Please report any issue on https://github.com/ndechesne/meta-qcom/issues

## Maintainer(s)

Nicolas Dechesne <nicolas.dechesne@linaro.org>
