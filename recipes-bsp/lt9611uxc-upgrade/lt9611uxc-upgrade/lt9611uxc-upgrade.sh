#!/bin/sh

set -e

if [ ! -r /lib/firmware/lt9611uxc_fw.bin ] ; then
	echo "LT9611UXC firmware not found"
	exit 1
fi

if [ ! -d /sys/bus/i2c/drivers/lt9611uxc ] ; then
	modprobe lontium-lt9611uxc
	sleep 1
fi

for f in /sys/bus/i2c/drivers/lt9611uxc/* ; do
	[ -L $f ] || continue
	version=`cat $f/lt9611uxc_firmware`
	if [ "$version" -lt "43" ] ; then
		echo > $f/lt9611uxc_firmware
	fi
done
