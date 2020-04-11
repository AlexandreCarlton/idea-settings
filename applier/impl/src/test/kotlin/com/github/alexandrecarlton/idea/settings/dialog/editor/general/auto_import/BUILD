load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "auto_import",
    tests = [
        ":java_auto_import_settings_applier_test",
        ":kotlin_auto_import_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "java_auto_import_settings_applier_test",
    srcs = ["JavaAutoImportSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import.JavaAutoImportSettingsApplierTest",
    runtime_deps = ["@idea-IC//:java_runtime"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/general/auto_import",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/general/auto_import",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)

kt_jvm_test(
    name = "kotlin_auto_import_settings_applier_test",
    srcs = ["KotlinAutoImportSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.editor.general.auto_import.KotlinAutoImportSettingsApplierTest",
    runtime_deps = ["@idea-IC//:Kotlin_runtime"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/general/auto_import",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/general/auto_import",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:plugins/Kotlin/lib/kotlin-plugin",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
