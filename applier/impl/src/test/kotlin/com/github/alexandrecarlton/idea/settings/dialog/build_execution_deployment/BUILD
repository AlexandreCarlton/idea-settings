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
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.BuildExecutionDeploymentSettingsApplierTest",
    runtime_deps = ["@idea-IC//:java_runtime"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment/build_tools",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment/compiler",
        "@idea-IC//:lib/platform-impl",
        "@maven//:com_google_guava_guava",
        "@maven//:io_mockk_mockk",
        "@maven//:junit_junit",
        "@maven//:org_xmlunit_xmlunit_assertj",
    ],
)
