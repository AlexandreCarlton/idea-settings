test_suite(
    name = "project",
    tests = [
        ":project_settings_applier_test",
    ],
)

java_test(
    name = "project_settings_applier_test",
    srcs = ["ProjectSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.project_settings.project.ProjectSettingsApplierTest",
    runtime_deps = [
        "@idea-IC//:runtime_deps",
        "@idea-IC//:test_deps",
    ],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/project_settings/project",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/project_settings/project",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/java-api",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
    ],
)
