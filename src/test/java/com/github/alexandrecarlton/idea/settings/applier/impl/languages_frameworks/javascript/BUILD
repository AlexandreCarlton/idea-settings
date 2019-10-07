test_suite(
    name = "javascript",
    tests = [":javascript_settings_applier_test"],
)

java_test(
    name = "javascript_settings_applier_test",
    srcs = ["JavascriptSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.javascript.JavascriptSettingsApplierTest",
    runtime_deps = [
        "@idea-IU//:test_runtime_deps",
    ],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/languages_frameworks/javascript",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/languages_frameworks/javascript",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/JavaScriptLanguage",
    ],
)
