# Upstream repo no longer has 'master' branch, and switched to
# 'main'. To avoid issue such as:
# 
# ERROR: rt-tests-1_1.1-r0 do_fetch: Fetcher failure: Unable to find
# revision dff174f994f547a5785d32454865f140daacb0f5 in branch master
# even from upstream
# 
# we need to set the default branch name to 'main' in the recipe.
# 
# Upstream patch is in progress

SRC_URI = "git://git.kernel.org/pub/scm/utils/rt-tests/rt-tests.git;branch=main \
           file://run-ptest \
           file://rt_bmark.py \
           file://0001-gzip-with-n-for-build-reproducibilty.patch \
"

