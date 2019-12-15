workspace(name = "idea_settings")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive", "http_jar")

# To view newer releases: https://www.jetbrains.com/intellij-repository/releases/
IDEA_VERSION = "2019.3"

IDEA_IC_SHA256 = "6c8d3f0b5adf05e5e64272975dfa50fe2895a334e441c1033b2074c56c9b28c8"

IDEA_IU_SHA256 = "4dde257fcecf163a7f33c40bba69142a35bc45043b66dd41cdc4f7303a87d66d"

IDEA_IC_SOURCES_SHA256 = "4dd103af9a0a0322b76ad07848a105fc154d5f5dfeae45e773bfae8607b65848"

WEBSTORM_SHA256 = "63ffa9d500182909078356157dd4c7ee97abfc55c51bced45d71423c7230e593"

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
    strip_prefix = "WebStorm-193.5233.80",
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
    sha256 = "54678552125753d9fc0a37736d140f1d2e69778d3e52cf454df41a913b964ede",
    strip_prefix = "rules_kotlin-legacy-1.3.0-rc3",
    url = "https://github.com/bazelbuild/rules_kotlin/archive/legacy-1.3.0-rc3.zip",
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
    sha256 = "e055ff971787a27d6942a83ffd182953988c88dfa82e89138ccc83bf410a65d6",
    strip_prefix = "bazel-integration-testing-2a4f6c244312c036e0f3a125ee6086637ee7723b",
    url = "https://github.com/bazelbuild/bazel-integration-testing/archive/2a4f6c244312c036e0f3a125ee6086637ee7723b.zip",
)

load("@build_bazel_integration_testing//tools:bazel_java_integration_test.bzl", "bazel_java_integration_test_deps")

bazel_java_integration_test_deps()

http_archive(
    name = "google_bazel_common",
    sha256 = "090d1f394c2bbeae37f091a9d7853bafc7a9b3174d1e100d762fdd07767a2269",
    strip_prefix = "bazel-common-1c8dcb31eed0713306cb6dc07f8334d84c925a01",
    urls = ["https://github.com/google/bazel-common/archive/1c8dcb31eed0713306cb6dc07f8334d84c925a01.zip"],
)

load("@google_bazel_common//:workspace_defs.bzl", "google_common_workspace_rules")

google_common_workspace_rules()

http_archive(
    name = "com_google_dagger",
    urls = ["https://github.com/google/dagger/archive/6c2568dfc708abfe2539343f0976356dc8cf1349.zip"],
    strip_prefix = "dagger-6c2568dfc708abfe2539343f0976356dc8cf1349",
    sha256 = "1ef40a620a34e2b627a16f4e734151cbbd1342b1774afef436aa1fa2abfbf02d",
)

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-3.0",
    sha256 = "62133c125bf4109dfd9d2af64830208356ce4ef8b165a6ef15bbff7460b35c3a",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/3.0.zip",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

load("@rules_jvm_external//:specs.bzl", "maven")

maven_install(
    artifacts = [
        "com.fasterxml.jackson.core:jackson-annotations:2.10.1",
        "com.fasterxml.jackson.core:jackson-core:2.10.1",
        "com.fasterxml.jackson.core:jackson-databind:2.10.1",
        "com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.10.1",
        "com.fasterxml.jackson.datatype:jackson-datatype-guava:2.10.1",
        "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.10.1",
        "com.google.dagger:dagger:2.25.2",
        "com.google.guava:guava:27.0.1-jre",
        "javax.inject:javax.inject:1",
        "junit:junit:4.12",
        "org.assertj:assertj-core:3.11.1",
        "org.mockito:mockito-core:2.28.2",
        "org.xmlunit:xmlunit-assertj:2.6.2",
        maven.artifact(
            group = "com.fasterxml.jackson.module",
            artifact = "jackson-module-kotlin",
            version = "2.10.1",
            exclusions = [
                # Keeping this generates a warning about bundling in a Kotlin runtime, but is necessary for deserialisation.
                # "org.jetbrains.kotlin:kotlin-reflect",
                "org.jetbrains.kotlin:kotlin-stdlib",
            ],
        ),
        maven.artifact(
            group = "com.google.dagger",
            artifact = "dagger-compiler",
            version = "2.25.2",
            exclusions = ["org.jetbrains.kotlin:kotlin-stdlib"],
        ),
    ],
    repositories = [
        "https://jcenter.bintray.com/",
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
    maven_install_json = "//:maven_install.json",
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()
