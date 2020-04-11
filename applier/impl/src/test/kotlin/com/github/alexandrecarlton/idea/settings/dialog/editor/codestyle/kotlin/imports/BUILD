load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "imports",
    tests = [
        ":kotlin_imports_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "kotlin_imports_settings_applier_test",
    srcs = ["KotlinImportsSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.imports.KotlinImportsSettingsApplierTest",
    runtime_deps = ["@idea-IC//:Kotlin_runtime"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/imports",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/imports",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/Kotlin/lib/kotlin-plugin",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
