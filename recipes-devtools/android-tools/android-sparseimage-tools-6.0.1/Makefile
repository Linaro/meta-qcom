.PHONY: all

all: make_ext4fs simg2img img2simg append2simg

libext4_utils_src_files := $(addprefix $(srcdir)/extras/ext4_utils/,\
    make_ext4fs.c \
    ext4fixup.c \
    ext4_utils.c \
    allocate.c \
    contents.c \
    extent.c \
    indirect.c \
    sha1.c \
    wipe.c \
    crc16.c \
    ext4_sb.c \
    canned_fs_config.c \
)

libsparse_src_files = $(addprefix $(srcdir)/core/libsparse/,\
        backed_block.c \
        output_file.c \
        sparse.c \
        sparse_crc32.c \
        sparse_err.c \
        sparse_read.c \
)

make_ext4fs: $(srcdir)/extras/ext4_utils/make_ext4fs_main.c $(libext4_utils_src_files) $(libsparse_src_files)
	$(CC) $(CFLAGS) -DHOST -I$(srcdir)/core/libsparse/include -I$(srcdir)/core/include -I$(srcdir)/extras/ext4_utils/include $(LDFLAGS) -o $@ $^ -lz

simg2img: $(srcdir)/core/libsparse/simg2img.c $(libsparse_src_files)
	$(CC) $(CFLAGS) -DHOST -I$(srcdir)/core/libsparse/include -I$(srcdir)/core/include $(LDFLAGS) -o $@ $^ -lz

img2simg: $(srcdir)/core/libsparse/img2simg.c $(libsparse_src_files)
	$(CC) $(CFLAGS) -DHOST -I$(srcdir)/core/libsparse/include -I$(srcdir)/core/include $(LDFLAGS) -o $@ $^ -lz

append2simg: $(srcdir)/core/libsparse/append2simg.c $(libsparse_src_files)
	$(CC) $(CFLAGS) -DHOST -I$(srcdir)/core/libsparse/include -I$(srcdir)/core/include $(LDFLAGS) -o $@ $^ -lz

.PHONY: install
install:
	install -d $(DESTDIR)$(bindir)
	install -m 0755 make_ext4fs simg2img img2simg append2simg $(DESTDIR)$(bindir)
