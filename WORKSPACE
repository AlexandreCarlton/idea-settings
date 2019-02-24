load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive", "http_jar")

BAZEL_DEPS_COMMIT = "e3f77e22d9f5b070915067a766607cfc96835c98"

BAZEL_DEPS_SHA256 = "5dac398f0dc57f76566642cf21f10960eed83f4bb56c5860170c0582f5581194"

CHECKSTYLE_IDEA_VERSION = "5.24.2"

CHECKSTYLE_IDEA_SHA256 = "1622761d25d318a8281732f0a16e805b44157161c6ffb3e88e6c3f79d9ca97fa"

# To consult further release: https://www.jetbrains.com/intellij-repository/releases/
IDEA_IC_VERSION = "2018.3.3"

IDEA_IC_PREFIX = "idea-IC-183.5153.38"

IDEA_IC_SHA256 = "15f9676c7807e9f3e462500c5fefd4de543ed5804c588bbb3719dbd94e1d3db1"

IDEA_IC_SOURCES_SHA256 = "276e548135d2c9d5a4a0880dead9a0f48aecdfd1e78074a3c0d48cb2575ad6a0"

http_archive(
    name = "idea-IC",
    build_file = "idea-IC.BUILD",
    sha256 = IDEA_IC_SHA256,
    strip_prefix = IDEA_IC_PREFIX,
    # We don't pull from the same place we get the sources jar because it does not contain a bundled JRE (which is necessary to work properly).
    # If we can find another tools.jar to use, we can use the same url as sources.
    url = "https://download.jetbrains.com/idea/ideaIC-{0}.tar.gz".format(IDEA_IC_VERSION),
)

http_jar(
    name = "idea-IC-sources",
    sha256 = IDEA_IC_SOURCES_SHA256,
    url = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC/{0}/ideaIC-{0}-sources.jar".format(IDEA_IC_VERSION),
)

http_archive(
    name = "bazel-deps",
    sha256 = BAZEL_DEPS_SHA256,
    strip_prefix = "bazel-deps-{0}".format(BAZEL_DEPS_COMMIT),
    url = "https://github.com/johnynek/bazel-deps/archive/{0}.zip".format(BAZEL_DEPS_COMMIT),
)

http_archive(
    name = "CheckStyle-IDEA",
    build_file = "CheckStyle-IDEA.BUILD",
    sha256 = CHECKSTYLE_IDEA_SHA256,
    strip_prefix = "CheckStyle-IDEA",
    url = "https://plugins.jetbrains.com/files/1065/54249/checkstyle-idea-{0}.zip".format(CHECKSTYLE_IDEA_VERSION),
)

# bazel-deps will soon produce a jar that can be used to run @bazel-deps//:parse from within
# this project.
load("//third_party:package-lock.bzl", "maven_dependencies")

maven_dependencies()
