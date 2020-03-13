load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "nodejs_and_npm",
    tests = [":nodejs_and_npm_settings_applier_test"],
)

kt_jvm_test(
    name = "nodejs_and_npm_settings_applier_test",
    srcs = ["NodejsAndNpmSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.nodejs_and_npm.NodejsAndNpmSettingsApplierTest",
    runtime_deps = [
        "@idea-IU//:test_runtime_deps",
    ],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks/nodejs_and_npm",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks/nodejs_and_npm",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/JavaScriptLanguage",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
