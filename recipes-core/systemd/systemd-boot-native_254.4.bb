require recipes-core/systemd/systemd.inc

inherit native

RRECOMMENDS:${PN} += "python3-pefile-native"

COMPATIBLE_HOST = "(aarch64.*|arm.*|x86_64.*|i.86.*)-linux"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/src/ukify/ukify.py ${D}${bindir}/ukify
}
