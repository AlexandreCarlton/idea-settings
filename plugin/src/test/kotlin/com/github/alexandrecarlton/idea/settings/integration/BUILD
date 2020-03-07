load("@build_bazel_integration_testing//tools:bazel_java_integration_test.bzl", "bazel_java_integration_test")
load("@build_bazel_integration_testing//tools:common.bzl", "GET_LATEST_BAZEL_VERSIONS")
load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

test_suite(
    name = "integration",
    tests = [
        ":auto_integration_test",
        ":javapoet_integration_test",
    ],
)

bazel_java_integration_test(
    name = "auto_integration_test",
    data = [
        "//:apply-idea-settings.sh",
        "//:plugins_tar",
        "@auto",
        "@idea-IC//:bin/idea.sh",
        "@idea-IC//:bin/linux/idea64.vmoptions",
    ],
    external_deps = ["@bazel_tools//tools/bash/runfiles"],
    test_class = "com.github.alexandrecarlton.idea.settings.integration.AutoIntegrationTest",
    versions = GET_LATEST_BAZEL_VERSIONS(count = 1),
    runtime_deps = [":integration_lib"],
)

bazel_java_integration_test(
    name = "javapoet_integration_test",
    data = [
        "//:apply-idea-settings.sh",
        "//:plugins_tar",
        "@idea-IC//:bin/idea.sh",
        "@idea-IC//:bin/linux/idea64.vmoptions",
        "@javapoet",
    ],
    external_deps = ["@bazel_tools//tools/bash/runfiles"],
    test_class = "com.github.alexandrecarlton.idea.settings.integration.JavapoetIntegrationTest",
    versions = GET_LATEST_BAZEL_VERSIONS(count = 1),
    runtime_deps = [":integration_lib"],
)

kt_jvm_library(
    name = "integration_lib",
    testonly = True,
    srcs = glob(["*.kt"]),
    deps = [
        "@build_bazel_integration_testing//java/build/bazel/tests/integration:workspace_driver",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
        "@maven//:org_xmlunit_xmlunit_assertj",
    ],
)
