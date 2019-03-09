load("//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures:javapoet.bzl", "java_test_javapoet")

test_suite(
    name = "compiler",
    tests = [
        ":compiler_settings_applier_test",
    ],
)

java_test_javapoet(
    name = "compiler_settings_applier_test",
    srcs = ["CompilerSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler.CompilerSettingsApplierTest",
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/starter",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/xmlunit:xmlunit_assertj",
    ],
)
