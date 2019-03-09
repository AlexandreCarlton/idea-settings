load("//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures:javapoet.bzl", "java_test_javapoet")

test_suite(
    name = "build_execution_deployment",
    tests = [
        ":build_execution_deployment_settings_applier_test",
    ],
)

java_test_javapoet(
    name = "build_execution_deployment_settings_applier_test",
    srcs = ["BuildExecutionDeploymentSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.BuildExecutionDeploymentSettingsApplierTest",
    deps = [
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/xmlunit:xmlunit_assertj",
    ],
)
