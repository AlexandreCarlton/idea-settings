load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "maven",
    tests = [
        ":maven_importing_settings_applier_test",
        ":maven_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "maven_settings_applier_test",
    srcs = ["MavenSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven.MavenSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment/build_tools/maven",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment/build_tools/maven",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/maven/lib/maven",
        "@maven//:io_mockk_mockk",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)

kt_jvm_test(
    name = "maven_importing_settings_applier_test",
    srcs = ["MavenImportingSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.build_execution_deployment.build_tools.maven.MavenImportingSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment/build_tools/maven",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment/build_tools/maven",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/maven/lib/maven",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
