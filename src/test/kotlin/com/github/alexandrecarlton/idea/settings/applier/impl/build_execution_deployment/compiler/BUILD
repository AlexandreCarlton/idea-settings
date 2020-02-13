load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "compiler",
    tests = [
        ":compiler_settings_applier_test",
        ":nullable_not_null_configuration_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "compiler_settings_applier_test",
    srcs = ["CompilerSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler.CompilerSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment/compiler",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment/compiler",
        "//src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "@idea-IC//:plugins/java/lib/java-api",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@maven//:io_mockk_mockk",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)

kt_jvm_test(
    name = "nullable_not_null_configuration_settings_applier_test",
    srcs = ["NullableNotNullConfigurationSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler.NullableNotNullConfigurationSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment/compiler",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment/compiler",
        "//src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "@idea-IC//:plugins/java/lib/java-api",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
