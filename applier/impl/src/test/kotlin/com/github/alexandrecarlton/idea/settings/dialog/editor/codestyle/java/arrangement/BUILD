load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "arrangement",
    tests = [":java_arrangement_settings_applier_test"],
)

kt_jvm_test(
    name = "java_arrangement_settings_applier_test",
    srcs = ["JavaArrangementSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.editor.codestyle.java.arrangement.JavaArrangementSettingsApplierTest",
    runtime_deps = ["@idea-IC//:java_runtime"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/java/arrangement",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/java/arrangement",
        "@idea-IC//:lib/idea",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/java/lib/java-api",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
