load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "project_settings",
    tests = [
        ":sonarlint_project_settings_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "sonarlint_project_settings_settings_applier_test",
    srcs = ["SonarlintProjectSettingsSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.tools.sonarlint.project_settings.SonarlintProjectSettingsSettingsApplierTest",
    runtime_deps = [
        "@SonarLint//:runtime",
        "@idea-IC//:runtime",
    ],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/tools/sonarlint/project_settings",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/tools/sonarlint/project_settings",
        "@SonarLint//:lib/sonarlint-intellij",
        "@idea-IC//:lib/util",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
