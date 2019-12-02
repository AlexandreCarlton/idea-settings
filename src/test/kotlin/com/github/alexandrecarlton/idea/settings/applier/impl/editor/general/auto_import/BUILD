load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "auto_import",
    tests = [
        ":java_auto_import_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "java_auto_import_settings_applier_test",
    srcs = ["JavaAutoImportSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import.JavaAutoImportSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/editor/general/auto_import",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/general/auto_import",
        "//src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:plugins/java/lib/java-impl",
    ],
)
