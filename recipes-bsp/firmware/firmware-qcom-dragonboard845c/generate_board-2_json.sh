JSON="$2"

iter=0
echo "[" > "${JSON}"
for file in $1/bdwlan.*; do
    [[ $file == *.txt ]] && continue

    iter=$((iter+1))
    [ $iter -ne 1 ] && echo "  }," >> "${JSON}"

    echo "  {" >> "${JSON}"
    echo "          \"data\": \"$file\"," >> "${JSON}"
    if [[ $file == */bdwlan.bin ]]; then
        file_ext="ff"
    else
        file_ext="$(printf '%x\n' "$(basename "${file}" | sed -E 's:^.*\.b?([0-9a-f]*)$:0x\1:')")"
    fi
    echo "          \"names\": [\"bus=snoc,qmi-board-id=${file_ext}\"]" >> "${JSON}"
done

echo "  }" >> "${JSON}"
echo "]" >> "${JSON}"

