load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "project",
    tests = [
        ":project_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "project_settings_applier_test",
    srcs = ["ProjectSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.project_settings.project.ProjectSettingsApplierTest",
    runtime_deps = ["@idea-IC//:java_runtime"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/project_settings/project",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/project_settings/project",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:plugins/java/lib/java-api",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
