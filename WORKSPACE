load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive", "http_jar")

IDEA_IC_VERSION = "2018.3.3"
IDEA_IC_PREFIX = "idea-IC-183.5153.38"
IDEA_IC_SHA256 = "15f9676c7807e9f3e462500c5fefd4de543ed5804c588bbb3719dbd94e1d3db1"
IDEA_IC_SOURCES_SHA256 = "276e548135d2c9d5a4a0880dead9a0f48aecdfd1e78074a3c0d48cb2575ad6a0"

http_archive(
    name = "idea-IC",
    build_file = "idea-IC.BUILD",
    sha256 = IDEA_IC_SHA256,
    # We don't pull from the same place we get the sources jar because it does not contain a bundled JRE (which is necessary to work properly).
    url = "https://download.jetbrains.com/idea/ideaIC-{0}.tar.gz".format(IDEA_IC_VERSION),
    strip_prefix = IDEA_IC_PREFIX,
)

http_jar(
    name = "idea-IC-sources",
    sha256 = IDEA_IC_SOURCES_SHA256,
    url = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC/{0}/ideaIC-{0}-sources.jar".format(IDEA_IC_VERSION)
)
