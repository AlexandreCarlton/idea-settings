load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "checkstyle",
    tests = [":checkstyle_settings_applier_test"],
)

kt_jvm_test(
    name = "checkstyle_settings_applier_test",
    srcs = ["CheckstyleSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.checkstyle.CheckstyleSettingsApplierTest",
    runtime_deps = [
        "@CheckStyle-IDEA//:test_runtime_deps",
        "@idea-IC//:test_runtime_deps",
    ],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/other_settings/checkstyle",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/other_settings/checkstyle",
        "//src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@CheckStyle-IDEA//:lib/checkstyle-idea",
    ],
)
