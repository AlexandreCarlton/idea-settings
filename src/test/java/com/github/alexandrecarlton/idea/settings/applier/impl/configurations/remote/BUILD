test_suite(
    name = "remote",
    tests = [
        ":remote_settings_applier_test",
    ],
)

java_test(
    name = "remote_settings_applier_test",
    srcs = ["RemoteSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.configurations.remote.RemoteSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/configurations/remote",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/configurations/remote",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/java/lib/java-impl",
    ],
)
