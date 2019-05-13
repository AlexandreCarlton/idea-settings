load("//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures:javapoet.bzl", "java_test_javapoet")

test_suite(
    name = "spelling",
    tests = [
        ":spelling_settings_applier_test",
    ],
)

java_test_javapoet(
    name = "spelling_settings_applier_test",
    size = "large",
    srcs = ["SpellingSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.spelling.SpellingSettingsApplierTest",
    deps = [
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/xmlunit:xmlunit_assertj",
    ],
)
