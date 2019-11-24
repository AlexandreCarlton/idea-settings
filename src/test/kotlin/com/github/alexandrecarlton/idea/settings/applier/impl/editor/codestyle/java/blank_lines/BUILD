load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "blank_lines",
    tests = [
        ":java_keep_maximum_blank_lines_settings_applier_test",
        ":java_minimum_blank_lines_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "java_keep_maximum_blank_lines_settings_applier_test",
    srcs = ["JavaKeepMaximumBlankLinesSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines.JavaKeepMaximumBlankLinesSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/codestyle/java/blank_lines",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/blank_lines",
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

kt_jvm_test(
    name = "java_minimum_blank_lines_settings_applier_test",
    srcs = ["JavaMinimumBlankLinesSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.blank_lines.JavaMinimumBlankLinesSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/codestyle/java/blank_lines",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/blank_lines",
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
