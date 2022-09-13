# Copyright (C) 2021 Linaro
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-linaro-qcom.inc

# SRCBRANCH set to "release/qcomlt-5.15" in linux-linaro-qcom.inc
SRCREV = "9bc25b368335b6d3d59be44db0c4818bdfbfa546"

# SRCBRANCH set to adp stable release branch
SRCBRANCH:sa8155p = "release/sa8155p-adp/v5.15.y"
SRCREV:sa8155p = "38b7066ac1084c74759f1314c54b5735a1e5031d"
