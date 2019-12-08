load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "spelling",
    tests = [
        ":spelling_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "spelling_settings_applier_test",
    srcs = ["SpellingSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.spelling.SpellingSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/editor/spelling",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/spelling",
        "//src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
        "@idea-IC//:lib/spellchecker",
    ],
)
