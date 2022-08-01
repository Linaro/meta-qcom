require lk.inc

LK_BRANCH = "release/LA.HB.1.3.2-19600-8x96.0+rescue"
LK_REVISION = "5f94a3cf27d6c6fa65efbad51f85d57df83efb28"
LK_SOC = "msm8996"
LK_MACHINE = "dragonboard-820c"
LK_FLAVOUR = "-sd-rescue"

EXTRA_OEMAKE += "VERIFIED_BOOT=1"
