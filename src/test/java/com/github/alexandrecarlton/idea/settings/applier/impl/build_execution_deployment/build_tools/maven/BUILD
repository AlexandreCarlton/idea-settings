test_suite(
    name = "maven",
    tests = [
        ":maven_importing_settings_applier_test",
        ":maven_settings_applier_test",
    ],
)

java_test(
    name = "maven_settings_applier_test",
    srcs = ["MavenSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven.MavenSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment/build_tools/maven",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment/build_tools/maven",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "//third_party/maven/org/mockito:mockito_core",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/maven/lib/maven",
    ],
)

java_test(
    name = "maven_importing_settings_applier_test",
    srcs = ["MavenImportingSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.build_tools.maven.MavenImportingSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment/build_tools/maven",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment/build_tools/maven",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/maven/lib/maven",
    ],
)
