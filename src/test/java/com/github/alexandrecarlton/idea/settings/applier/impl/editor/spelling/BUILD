test_suite(
    name = "spelling",
    tests = [
        ":spelling_settings_applier_test",
    ],
)

java_test(
    name = "spelling_settings_applier_test",
    srcs = ["SpellingSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.spelling.SpellingSettingsApplierTest",
    runtime_deps = [
        "@idea-IC//:runtime_deps",
        "@idea-IC//:test_deps",
    ],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/spelling",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/spelling",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/spellchecker",
    ],
)
