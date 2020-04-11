load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "eslint",
    tests = [":eslint_settings_applier_test"],
)

kt_jvm_test(
    name = "eslint_settings_applier_test",
    srcs = ["EslintSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.code_quality_tools.eslint.EslintSettingsApplierTest",
    runtime_deps = ["@idea-IU//:JavaScriptLanguage_runtime"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks/javascript/code_quality_tools/eslint",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks/javascript/code_quality_tools/eslint",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/JavaScriptLanguage",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
