load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "javascript",
    tests = [":javascript_settings_applier_test"],
)

kt_jvm_test(
    name = "javascript_settings_applier_test",
    srcs = ["JavascriptSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.javascript.JavascriptSettingsApplierTest",
    runtime_deps = [
        "@idea-IU//:JavaScriptLanguage_runtime",
    ],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks/javascript",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks/javascript",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/JavaScriptLanguage",
        "@maven//:io_mockk_mockk",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
