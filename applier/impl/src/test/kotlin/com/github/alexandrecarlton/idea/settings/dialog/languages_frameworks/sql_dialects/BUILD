load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "sql_dialects",
    tests = [":sql_dialects_settings_applier_test"],
)

kt_jvm_test(
    name = "sql_dialects_settings_applier_test",
    srcs = ["SqlDialectsSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.languages_frameworks.sql_dialects.SqlDialectsSettingsApplierTest",
    runtime_deps = [
        "@idea-IU//:DatabaseTools_runtime",
    ],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks/sql_dialects",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks/sql_dialects",
        "@idea-IC//:lib/idea",
        "@idea-IU//:plugins/DatabaseTools/lib/database-impl",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
