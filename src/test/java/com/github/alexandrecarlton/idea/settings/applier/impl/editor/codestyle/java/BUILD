test_suite(
    name = "java",
    tests = [
        ":java_import_settings_applier_test",
    ],
)

java_test(
    name = "java_import_settings_applier_test",
    srcs = ["JavaImportSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.JavaImportSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/codestyle/java",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/idea",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:plugins/java/lib/java-impl",
    ],
)
