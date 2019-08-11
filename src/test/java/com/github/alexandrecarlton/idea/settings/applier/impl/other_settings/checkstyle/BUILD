test_suite(
    name = "checkstyle",
    tests = [
        ":checkstyle_settings_applier_test",
    ],
)

java_test(
    name = "checkstyle_settings_applier_test",
    srcs = ["CheckstyleSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.other_settings.checkstyle.CheckstyleSettingsApplierTest",
    runtime_deps = [
        "@CheckStyle-IDEA//:test_runtime_deps",
        "@idea-IC//:runtime_deps",
        "@idea-IC//:test_deps",
    ],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/other_settings/checkstyle",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/other_settings/checkstyle",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@CheckStyle-IDEA//:lib/checkstyle-idea",
    ],
)
