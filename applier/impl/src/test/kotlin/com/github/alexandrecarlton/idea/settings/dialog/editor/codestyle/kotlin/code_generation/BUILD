load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "code_generation",
    tests = [
        ":kotlin_code_generation_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "kotlin_code_generation_settings_applier_test",
    srcs = ["KotlinCodeGenerationSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.kotlin.code_generation.KotlinCodeGenerationSettingsApplierTest",
    runtime_deps = ["@idea-IC//:Kotlin_runtime"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/code_generation",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/code_generation",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
