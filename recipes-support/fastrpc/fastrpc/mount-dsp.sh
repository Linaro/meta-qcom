#!/bin/sh

set -e

modprobe socinfo || true

if [ -r /sys/firmware/devicetree/base/model ] ; then
	MACHINE=`cat /sys/firmware/devicetree/base/model`
	case "$MACHINE" in
		*DB820c*)
			WHAT=/usr/share/qcom/apq8096/Qualcomm/db820c/dsp
			;;
		*"Dragonboard 845c"*)
			WHAT=/usr/share/qcom/sdm845/Thundercomm/db845c/dsp
			;;
		*"Robotics RB1"*)
			WHAT=/usr/share/qcom/qcm2290/Thundercomm/RB1/dsp
			;;
		*"QRB4210 RB2"*)
			WHAT=/usr/share/qcom/qrb4210/Thundercomm/RB2/dsp
			;;
		*"Robotics RB5"*)
			WHAT=/usr/share/qcom/sm8250/Thundercomm/RB5/dsp
			;;
	esac
fi

if [ -z "$WHAT" -o ! -d "$WHAT" ] ; then
	if [ -h /dev/disk/by-partlabel/dsp_a ] ; then
		WHAT=/dev/disk/by-partlabel/dsp_a
	else
		WHAT=/dev/disk/by-partlabel/dsp
	fi
fi

if [ -d "$WHAT" ] ; then
	mount $WHAT /usr/lib/rfsa -o bind
elif [ -h /dev/disk/by-partlabel/dsp_a ] ; then
	mount /dev/disk/by-partlabel/dsp_a /usr/lib/rfsa -o ro
elif [ -h /dev/disk/by-partlabel/dsp ] ; then
	mount /dev/disk/by-partlabel/dsp /usr/lib/rfsa -o ro
else
	echo "Not mounting /usr/lib/rfsa, partition/image not found" 1>&2
fi
