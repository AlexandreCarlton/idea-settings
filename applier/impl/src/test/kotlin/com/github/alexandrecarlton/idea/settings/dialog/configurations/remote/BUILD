load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "remote",
    tests = [
        ":remote_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "remote_settings_applier_test",
    srcs = ["RemoteSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.configurations.remote.RemoteSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/remote",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/remote",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
