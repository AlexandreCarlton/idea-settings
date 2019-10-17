test_suite(
    name = "sql_dialects",
    tests = [":sql_dialects_settings_applier_test"],
)

java_test(
    name = "sql_dialects_settings_applier_test",
    srcs = ["SqlDialectsSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.languages_frameworks.sql_dialects.SqlDialectsSettingsApplierTest",
    runtime_deps = [
        "@idea-IU//:test_runtime_deps",
    ],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/languages_frameworks/sql_dialects",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/languages_frameworks/sql_dialects",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/idea",
        "@idea-IU//:plugins/DatabaseTools/lib/database-impl",
    ],
)
