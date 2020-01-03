load("@build_bazel_integration_testing//tools:bazel_java_integration_test.bzl", "bazel_java_integration_test")
load("@build_bazel_integration_testing//tools:common.bzl", "GET_LATEST_BAZEL_VERSIONS")

test_suite(
    name = "integration",
    tests = [
        ":AutoIntegrationTest",
        ":JavapoetIntegrationTest",
    ],
)

bazel_java_integration_test(
    name = "AutoIntegrationTest",
    srcs = [
        "AbstractIntegrationTest.java",
        "AutoIntegrationTest.java",
    ],
    data = [
        "//:apply-idea-settings.sh",
        "//:plugins_tar",
        "@auto",
        "@idea-IC//:bin/idea.sh",
        "@idea-IC//:bin/linux/idea64.vmoptions",
    ],
    external_deps = [
        "@bazel_tools//tools/bash/runfiles",
    ],
    versions = GET_LATEST_BAZEL_VERSIONS(count = 1),
    deps = [
        "@maven//:org_assertj_assertj_core",
        "@maven//:org_xmlunit_xmlunit_assertj",
    ],
)

bazel_java_integration_test(
    name = "JavapoetIntegrationTest",
    srcs = [
        "AbstractIntegrationTest.java",
        "JavapoetIntegrationTest.java",
    ],
    data = [
        "//:apply-idea-settings.sh",
        "//:plugins_tar",
        "@idea-IC//:bin/idea.sh",
        "@idea-IC//:bin/linux/idea64.vmoptions",
        "@javapoet",
    ],
    external_deps = [
        "@bazel_tools//tools/bash/runfiles",
    ],
    versions = GET_LATEST_BAZEL_VERSIONS(count = 1),
    deps = [
        "@maven//:org_assertj_assertj_core",
        "@maven//:org_xmlunit_xmlunit_assertj",
    ],
)
