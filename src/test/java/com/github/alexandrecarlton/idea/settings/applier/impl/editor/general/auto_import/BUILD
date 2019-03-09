load("//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures:javapoet.bzl", "java_test_javapoet")

test_suite(
    name = "auto_import",
    tests = [
        ":java_auto_import_settings_applier_test",
    ],
)

java_test_javapoet(
    name = "java_auto_import_settings_applier_test",
    srcs = ["JavaAutoImportSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.general.auto_import.JavaAutoImportSettingsApplierTest",
    deps = [
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/xmlunit:xmlunit_assertj",
    ],
)
