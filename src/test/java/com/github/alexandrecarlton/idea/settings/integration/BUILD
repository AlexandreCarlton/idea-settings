load("@build_bazel_integration_testing//tools:bazel_java_integration_test.bzl", "bazel_java_integration_test")

load("@build_bazel_integration_testing//tools:common.bzl", "GET_LATEST_BAZEL_VERSIONS")

test_suite(
    name = "integration",
    tests = [
        ":JavapoetIntegrationTest",
    ],
)

bazel_java_integration_test(
    name = "JavapoetIntegrationTest",
    srcs = ["JavapoetIntegrationTest.java"],
    data = [
        "//:apply-idea-settings-sh",
        "//:idea-settings",
        "@CheckStyle-IDEA//:lib/checkstyle-idea_jar",
        "@idea-IC//:bin/idea.sh",
        "@idea-IC//:bin/linux/idea64.vmoptions",
        "@javapoet",
    ],
    versions = GET_LATEST_BAZEL_VERSIONS(count=1),
    external_deps = [
        "@bazel_tools//tools/bash/runfiles",
    ],
    deps = [
        "//third_party/maven/org/assertj:assertj_core",
        "//third_party/maven/org/xmlunit:xmlunit_assertj",
    ],
)
