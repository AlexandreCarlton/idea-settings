load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "build_execution_deployment",
    tests = [
        ":build_execution_deployment_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "build_execution_deployment_settings_applier_test",
    srcs = ["BuildExecutionDeploymentSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.BuildExecutionDeploymentSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment/build_tools",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment/compiler",
        "//src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "@idea-IC//:lib/platform-impl",
        "@maven//:com_google_guava_guava",
        "@maven//:io_mockk_mockk",
        "@maven//:junit_junit",
        "@maven//:org_xmlunit_xmlunit_assertj",
    ],
)
