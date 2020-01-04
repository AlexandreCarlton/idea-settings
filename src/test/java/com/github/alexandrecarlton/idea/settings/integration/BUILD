load("@build_bazel_integration_testing//tools:bazel_java_integration_test.bzl", "bazel_java_integration_test")
load("@build_bazel_integration_testing//tools:common.bzl", "GET_LATEST_BAZEL_VERSIONS")

test_suite(
    name = "integration",
    tests = [
        ":AutoIntegrationTest",
        ":JavapoetIntegrationTest",
    ],
)

java_library(
    name = "integration_lib",
    testonly = True,
    srcs = glob(["*.java"]),
    deps = [
        "@build_bazel_integration_testing//java/build/bazel/tests/integration:workspace_driver",
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
        "@maven//:org_xmlunit_xmlunit_assertj",
    ],
)

bazel_java_integration_test(
    name = "AutoIntegrationTest",
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
    name = "JavapoetIntegrationTest",
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
