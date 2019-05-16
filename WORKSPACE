load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive", "http_jar")

BAZEL_DEPS_COMMIT = "e3f77e22d9f5b070915067a766607cfc96835c98"

BAZEL_DEPS_SHA256 = "5dac398f0dc57f76566642cf21f10960eed83f4bb56c5860170c0582f5581194"

CHECKSTYLE_IDEA_VERSION = "5.24.2"

CHECKSTYLE_IDEA_SHA256 = "1622761d25d318a8281732f0a16e805b44157161c6ffb3e88e6c3f79d9ca97fa"

# To view newer releases: https://www.jetbrains.com/intellij-repository/releases/
IDEA_IC_VERSION = "191.7141.44" # 2019.1.2

IDEA_IC_SHA256 = "e045751adabe2837203798270e1dc173128fe3e607e3025d4f8110c7ed4cc499"

IDEA_IC_SOURCES_SHA256 = "a86b0af9758aa70360fd4113db878a91a10e67f6b0816aa8826ad5d9c4d17894"

http_archive(
    name = "idea-IC",
    build_file = "idea-IC.BUILD",
    sha256 = IDEA_IC_SHA256,
    url = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC/{0}/ideaIC-{0}.zip".format(IDEA_IC_VERSION),
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

# Test dependencies
http_archive(
    name = "javapoet",
    build_file = "javapoet.BUILD",
    sha256 = "6b3fc0ae4e321286d09ce633037152a3194f7ebbd6d8b06a9f195fc7c9255d65",
    strip_prefix = "javapoet-javapoet-1.11.1",
    url = "https://github.com/square/javapoet/archive/javapoet-1.11.1.zip",
)
