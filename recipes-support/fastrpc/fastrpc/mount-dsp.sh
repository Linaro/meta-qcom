#!/bin/sh

set -e

if [ -r /sys/devices/soc0/machine ] ; then
	MACHINE=`cat /sys/devices/soc0/machine`
	case $MACHINE in
		SM8250|QRB5160)
			WHAT=/lib/firmware/qcom/sm8250/dspso.bin
			;;
	esac
fi

if [ -z "$WHAT" -o ! -r "$WHAT"] ; then
	if [ -h /dev/disk/by-partlabel/dsp_a ] ; then
		WHAT=/dev/disk/by-partlabel/dsp_a
	else
		WHAT=/dev/disk/by-partlabel/dsp
	fi
fi

if [ -e "$WHAT" ] ; then
	mount $WHAT /usr/lib/rfsa -o ro
else
	echo "Not mounting /usr/lib/rfsa, partition/image not found" 1>&2
fi
