test_suite(
    name = "spring_boot",
    tests = [
        ":spring_boot_settings_applier_test",
    ],
)

java_test(
    name = "spring_boot_settings_applier_test",
    srcs = ["SpringBootSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.configurations.spring_boot.SpringBootSettingsApplierTest",
    runtime_deps = ["@idea-IU//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/configurations/spring_boot",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/configurations/spring_boot",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@idea-IU//:plugins/SpringBoot/lib/spring-boot-run",
    ],
)
