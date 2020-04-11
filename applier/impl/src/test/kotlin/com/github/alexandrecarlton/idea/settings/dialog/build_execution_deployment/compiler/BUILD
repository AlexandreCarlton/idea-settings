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
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.compiler.CompilerSettingsApplierTest",
    runtime_deps = ["@idea-IC//:java_runtime"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment/compiler",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment/compiler",
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
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.compiler.NullableNotNullConfigurationSettingsApplierTest",
    runtime_deps = ["@idea-IC//:java_runtime"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment/compiler",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment/compiler",
        "@idea-IC//:plugins/java/lib/java-api",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
