load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "build_execution_deployment",
    tests = [
        ":build_execution_deployment_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "build_execution_deployment_settings_applier_test",
    srcs = ["BuildExecutionDeploymentSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.BuildExecutionDeploymentSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment/build_tools",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment/compiler",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/mockito:mockito_core",
        "//third_party/maven/org/xmlunit:xmlunit_assertj",
        "@idea-IC//:lib/platform-impl",
    ],
)
