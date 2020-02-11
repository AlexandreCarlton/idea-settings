load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "save_actions",
    tests = [":save_actions_settings_applier_test"],
)

kt_jvm_test(
    name = "save_actions_settings_applier_test",
    srcs = ["SaveActionsSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.save_actions.SaveActionsSettingsApplierTest",
    runtime_deps = [
        "@idea-IC//:test_runtime_deps",
    ],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/other_settings/save_actions",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/other_settings/save_actions",
        "//src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "@Save-Actions//jar",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
