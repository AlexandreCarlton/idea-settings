load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "wrapping_and_braces",
    tests = [":java_wrapping_and_braces_settings_applier_test"],
)

kt_jvm_test(
    name = "java_wrapping_and_braces_settings_applier_test",
    srcs = ["JavaWrappingAndBracesSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.wrapping_and_braces.JavaWrappingAndBracesSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/codestyle/java/wrapping_and_braces",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/wrapping_and_braces",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/java/lib/java-api",
        "@idea-IC//:plugins/java/lib/java-impl",
    ],
)
