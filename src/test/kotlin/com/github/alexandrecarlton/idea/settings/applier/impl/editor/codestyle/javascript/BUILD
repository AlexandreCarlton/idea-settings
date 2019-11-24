load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "javascript",
    tests = [
        ":javascript_imports_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "javascript_imports_settings_applier_test",
    srcs = ["JavascriptImportsSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.javascript.JavascriptImportsSettingsApplierTest",
    runtime_deps = ["@idea-IU//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/codestyle/javascript",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/javascript",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        #        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/extensions",
        #        "@idea-IC//:lib/idea",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/JavaScriptLanguage",
    ],
)
