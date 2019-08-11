test_suite(
    name = "auto_import",
    tests = [
        ":java_auto_import_settings_applier_test",
    ],
)

java_test(
    name = "java_auto_import_settings_applier_test",
    srcs = ["JavaAutoImportSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import.JavaAutoImportSettingsApplierTest",
    runtime_deps = [
        "@idea-IC//:runtime_deps",
        "@idea-IC//:test_deps",
    ],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/general/auto_import",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/general/auto_import",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/java-impl",
        "@idea-IC//:lib/platform-impl",
    ],
)
