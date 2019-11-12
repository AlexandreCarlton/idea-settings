test_suite(
    name = "shell_script",
    tests = [
        ":shell_script_configuration_settings_applier_test",
    ],
)

java_test(
    name = "shell_script_configuration_settings_applier_test",
    srcs = ["ShellScriptConfigurationSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.configurations.shell_script.ShellScriptConfigurationSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/configurations/shell_script",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/configurations",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/sh/lib/sh",
    ],
)
