load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "shell_script",
    tests = [
        ":shell_script_configuration_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "shell_script_configuration_settings_applier_test",
    srcs = ["ShellScriptConfigurationSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.configurations.shell_script.ShellScriptConfigurationSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/configurations/shell_script",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations",
        "//src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/sh/lib/sh",
    ],
)
