load("//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures:javapoet.bzl", "java_test_javapoet")

test_suite(
    name = "project",
    tests = [
        ":project_settings_applier_test",
    ],
)

java_test_javapoet(
    name = "project_settings_applier_test",
    size = "large",
    srcs = ["ProjectSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.project.ProjectSettingsApplierTest",
    deps = [
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "//third_party/maven/org/xmlunit:xmlunit_assertj",
    ],
)
