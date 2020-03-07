load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "checkstyle",
    tests = [":checkstyle_settings_applier_test"],
)

kt_jvm_test(
    name = "checkstyle_settings_applier_test",
    srcs = ["CheckstyleSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.other_settings.checkstyle.CheckstyleSettingsApplierTest",
    runtime_deps = [
        "@CheckStyle-IDEA//:test_runtime_deps",
        "@idea-IC//:test_runtime_deps",
    ],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/other_settings/checkstyle",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/other_settings/checkstyle",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
        "@CheckStyle-IDEA//:lib/checkstyle-idea",
    ],
)
