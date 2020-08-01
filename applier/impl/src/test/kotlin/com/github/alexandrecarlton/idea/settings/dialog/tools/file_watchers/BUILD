load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "file_watchers",
    tests = [
        ":file_watcher_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "file_watcher_settings_applier_test",
    srcs = ["FileWatcherSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.tools.file_watchers.FileWatcherSettingsApplierTest",
    runtime_deps = [
        "@File-Watchers//:runtime",
        "@idea-IU//:JavaScriptLanguage_runtime",
    ],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/common/filetype",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/tools/file_watchers",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/common/filetype",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/tools/file_watchers",
        "@File-Watchers//:lib/fileWatcher",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/util",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/javascript-openapi",
        "@maven//:io_mockk_mockk",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
