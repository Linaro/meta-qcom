# Copyright (C) 2014-2021 Linaro
# Copyright (C) 2012, 2013 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION ??= "Linaro Qualcomm Landing team ${PV} Kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel

LOCALVERSION ?= "-linaro-lt-qcom"
SCMVERSION ?= "y"

SRCBRANCH = "release/qcomlt-${PV}"

COMPATIBLE_MACHINE = "(qcom)"

LINUX_LINARO_QCOM_GIT ?= "git://git.codelinaro.org/linaro/qcomlt/kernel.git;protocol=https"
SRC_URI = "${LINUX_LINARO_QCOM_GIT};branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

KERNEL_DEFCONFIG:aarch64 ?= "${S}/arch/arm64/configs/defconfig"
KERNEL_DEFCONFIG:arm ?= "${S}/arch/arm/configs/qcom_defconfig"
KERNEL_CONFIG_FRAGMENTS += "${S}/kernel/configs/distro.config"

inherit linux-qcom-bootimg

kernel_conf_variable() {
	sed -e "/CONFIG_$1[ =]/d;" -i ${B}/.config
	if test "$2" = "n"
	then
		echo "# CONFIG_$1 is not set" >> ${B}/.config
	else
		echo "CONFIG_$1=$2" >> ${B}/.config
	fi
}

do_configure:prepend() {
	if [ -f '${WORKDIR}/defconfig' ]; then
		cp '${WORKDIR}/defconfig' '${B}/.config'
	else
		cp '${KERNEL_DEFCONFIG}' '${B}/.config'
	fi

	kernel_conf_variable LOCALVERSION "\"${LOCALVERSION}\""
	kernel_conf_variable LOCALVERSION_AUTO y

	if [ "${SCMVERSION}" = "y" ]; then
		# Add GIT revision to the local version
		head=`git --git-dir=${S}/.git  rev-parse --verify --short HEAD 2> /dev/null`
		printf "%s%s" +g $head > ${B}/.scmversion
	fi

    # Check for kernel config fragments.  The assumption is that the config
    # fragment will be specified with the absolute path.  For example:
    #   * ${WORKDIR}/config1.cfg
    #   * ${S}/config2.cfg
    # Iterate through the list of configs and make sure that you can find
    # each one.  If not then error out.
    # NOTE: If you want to override a configuration that is kept in the kernel
    #       with one from the OE meta data then you should make sure that the
    #       OE meta data version (i.e. ${WORKDIR}/config1.cfg) is listed
    #       after the in kernel configuration fragment.
    # Check if any config fragments are specified.
    if [ ! -z "${KERNEL_CONFIG_FRAGMENTS}" ]
    then
        for f in ${KERNEL_CONFIG_FRAGMENTS}
        do
            # Check if the config fragment was copied into the WORKDIR from
            # the OE meta data
            if [ ! -e "$f" ]
            then
                echo "Could not find kernel config fragment $f"
                exit 1
            fi
        done

        # Now that all the fragments are located merge them.
        ( cd ${WORKDIR} && ${S}/scripts/kconfig/merge_config.sh -m -r -O ${B} ${B}/.config ${KERNEL_CONFIG_FRAGMENTS} 1>&2 )
    fi
}

do_configure:append() {
        oe_runmake -C ${S} O=${B} savedefconfig && cp ${B}/defconfig ${WORKDIR}/defconfig.saved
}
