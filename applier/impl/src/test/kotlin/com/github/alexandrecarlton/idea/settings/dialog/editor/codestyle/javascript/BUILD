load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "javascript",
    tests = [
        ":javascript_imports_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "javascript_imports_settings_applier_test",
    srcs = ["JavascriptImportsSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.javascript.JavascriptImportsSettingsApplierTest",
    runtime_deps = ["@idea-IU//:JavaScriptLanguage_runtime"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/javascript",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/javascript",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/JavaScriptLanguage",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
