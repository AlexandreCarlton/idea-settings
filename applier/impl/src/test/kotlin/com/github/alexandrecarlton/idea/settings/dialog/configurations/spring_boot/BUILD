load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "spring_boot",
    tests = [
        ":spring_boot_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "spring_boot_settings_applier_test",
    srcs = ["SpringBootSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.configurations.spring_boot.SpringBootSettingsApplierTest",
    runtime_deps = ["@idea-IU//:test_runtime_deps"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/spring_boot",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/spring_boot",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@idea-IU//:plugins/SpringBoot/lib/spring-boot-run",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
