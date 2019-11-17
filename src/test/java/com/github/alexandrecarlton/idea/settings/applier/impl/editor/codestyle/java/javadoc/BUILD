test_suite(
    name = "javadoc",
    tests = [":javadoc_settings_applier_test"],
)

java_test(
    name = "javadoc_settings_applier_test",
    srcs = ["JavadocSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.javadoc.JavadocSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/codestyle/java/javadoc",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/javadoc",
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
