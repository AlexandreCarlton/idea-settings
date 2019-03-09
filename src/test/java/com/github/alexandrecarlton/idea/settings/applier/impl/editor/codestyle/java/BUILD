load("//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures:javapoet.bzl", "java_test_javapoet")

test_suite(
    name = "java",
    tests = [
        ":java_import_settings_applier_test",
    ],
)

java_test_javapoet(
    name = "java_import_settings_applier_test",
    srcs = ["JavaImportSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.JavaImportSettingsApplierTest",
    deps = [
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/xmlunit:xmlunit_assertj",
    ],
)
