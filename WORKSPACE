workspace(name = "idea_settings")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive", "http_jar")

# To view newer releases: https://www.jetbrains.com/intellij-repository/releases/
IDEA_VERSION = "2019.2"

IDEA_IC_SHA256 = "9567f2a88c9d4c4a0495208914f07bd2dace78dad0fee31fb9f8a4adab3cc437"

IDEA_IU_SHA256 = "c1a980c6eeb528ee731ed52a5821981466b9205713926748051ff08a4ce8cfaf"

IDEA_IC_SOURCES_SHA256 = "0218f68cdc58d668ed2687f443719ba14c38fbf4a46ca2b7fda992b2a647acf8"

WEBSTORM_SHA256 = "6a51dd26a5f219ae576d3893e60ad3e15abb6b08b2fad8c94cd651aafbdaf86f"

http_archive(
    name = "idea-IC",
    build_file = "idea-IC.BUILD",
    sha256 = IDEA_IC_SHA256,
    url = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC/{0}/ideaIC-{0}.zip".format(IDEA_VERSION),
)

http_jar(
    name = "idea-IC-sources",
    sha256 = IDEA_IC_SOURCES_SHA256,
    url = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC/{0}/ideaIC-{0}-sources.jar".format(IDEA_VERSION),
)

http_archive(
    name = "idea-IU",
    build_file = "idea-IU.BUILD",
    sha256 = IDEA_IU_SHA256,
    url = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIU/{0}/ideaIU-{0}.zip".format(IDEA_VERSION),
)

http_archive(
    name = "WebStorm",
    build_file = "WebStorm.BUILD",
    sha256 = WEBSTORM_SHA256,
    strip_prefix = "WebStorm-192.5728.87",
    url = "https://download.jetbrains.com/webstorm/WebStorm-{0}.tar.gz".format(IDEA_VERSION),
)

http_archive(
    name = "bazel-deps",
    sha256 = "5dac398f0dc57f76566642cf21f10960eed83f4bb56c5860170c0582f5581194",
    strip_prefix = "bazel-deps-e3f77e22d9f5b070915067a766607cfc96835c98",
    url = "https://github.com/johnynek/bazel-deps/archive/e3f77e22d9f5b070915067a766607cfc96835c98.zip",
)

http_archive(
    name = "CheckStyle-IDEA",
    build_file = "CheckStyle-IDEA.BUILD",
    sha256 = "1622761d25d318a8281732f0a16e805b44157161c6ffb3e88e6c3f79d9ca97fa",
    strip_prefix = "CheckStyle-IDEA",
    url = "https://plugins.jetbrains.com/files/1065/54249/checkstyle-idea-5.24.2.zip",
)

http_archive(
    name = "intellij_with_bazel",
    sha256 = "bc3187cc94852f2d846cc427b9c1c420aa3f8726886dfe223f98872a0f490e9b",
    strip_prefix = "intellij-485a11132a7fd1b563357fa4263dd6ca3e3dd275",
    url = "https://github.com/bazelbuild/intellij/archive/485a11132a7fd1b563357fa4263dd6ca3e3dd275.zip",
)

http_archive(
    name = "io_bazel_rules_kotlin",
    sha256 = "fc7ae525c3aefbc0044cd636319f4039c152b117cefee6b6b1b7d9c7de715e15",
    strip_prefix = "rules_kotlin-legacy-1.3.0-rc1",
    url = "https://github.com/bazelbuild/rules_kotlin/archive/legacy-1.3.0-rc1.tar.gz",
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")

kotlin_repositories()

kt_register_toolchains()

http_archive(
    name = "rules_pkg",
    sha256 = "02de387c5ef874379e784ac968bf6efffe5285a168cab5a3169e08cfc634fd22",
    url = "https://github.com/bazelbuild/rules_pkg/releases/download/0.2.2/rules_pkg-0.2.2.tar.gz",
)

load("@rules_pkg//:deps.bzl", "rules_pkg_dependencies")

rules_pkg_dependencies()

# bazel-deps will soon produce a jar that can be used to run @bazel-deps//:parse from within
# this project.
load("//third_party:package-lock.bzl", "maven_dependencies")

maven_dependencies()

# Test dependencies
http_archive(
    name = "javapoet",
    build_file_content = """
package(default_visibility = ["//visibility:public"])
filegroup(
    name = "javapoet",
    srcs = glob(["**"]),
)""",
    sha256 = "6b3fc0ae4e321286d09ce633037152a3194f7ebbd6d8b06a9f195fc7c9255d65",
    strip_prefix = "javapoet-javapoet-1.11.1",
    url = "https://github.com/square/javapoet/archive/javapoet-1.11.1.zip",
)

http_archive(
    name = "auto",
    build_file_content = """
package(default_visibility = ["//visibility:public"])
filegroup(
    name = "auto",
    srcs = glob(["**"]),
)""",
    sha256 = "c926daf62d24bb6ad6289e997d67dcacbb1054e6cc2d9ba4c406f509e7c20875",
    strip_prefix = "auto-auto-value-1.6.6",
    url = "https://github.com/google/auto/archive/auto-value-1.6.6.zip",
)

http_archive(
    name = "maven-bin",
    build_file_content = """
package(default_visibility = ["//visibility:public"])
filegroup(
    name = "maven-bin",
    srcs = glob(["**"]),
)""",
    sha256 = "7e6cfe98dc9c16ae6aa267db277860594695144d719c99d1fc519e89346a8edf",
    strip_prefix = "apache-maven-3.6.1",
    url = "http://apache.mirror.amaze.com.au/maven/maven-3/3.6.1/binaries/apache-maven-3.6.1-bin.zip",
)

http_archive(
    name = "build_bazel_integration_testing",
    sha256 = "490554b98da4ce6e3e1e074e01b81e8440b760d4f086fccf50085a25528bf5cd",
    strip_prefix = "bazel-integration-testing-922d2b04bfb9721ab14ff6d26d4a8a6ab847aa07",
    url = "https://github.com/bazelbuild/bazel-integration-testing/archive/922d2b04bfb9721ab14ff6d26d4a8a6ab847aa07.zip",
)

load("@build_bazel_integration_testing//tools:bazel_java_integration_test.bzl", "bazel_java_integration_test_deps")

bazel_java_integration_test_deps()
