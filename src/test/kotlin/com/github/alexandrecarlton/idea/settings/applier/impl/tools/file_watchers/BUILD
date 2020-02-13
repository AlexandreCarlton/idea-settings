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
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.tools.file_watchers.FileWatcherSettingsApplierTest",
    runtime_deps = [
        "@WebStorm//:test_runtime_deps",
        "@idea-IU//:test_runtime_deps",
    ],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/common",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/tools/file_watchers",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/common",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/tools/file_watchers",
        "//src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "@WebStorm//:plugins/fileWatcher/lib/fileWatcher",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/util",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/javascript-openapi",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
