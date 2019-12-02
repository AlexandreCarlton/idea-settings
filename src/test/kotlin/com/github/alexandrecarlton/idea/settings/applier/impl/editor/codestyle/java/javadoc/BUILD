load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "javadoc",
    tests = [":javadoc_settings_applier_test"],
)

kt_jvm_test(
    name = "javadoc_settings_applier_test",
    srcs = ["JavadocSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.javadoc.JavadocSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/editor/codestyle/java/javadoc",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/javadoc",
        "//src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/java/lib/java-api",
        "@idea-IC//:plugins/java/lib/java-impl",
    ],
)
