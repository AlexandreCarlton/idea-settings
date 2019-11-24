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
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/common",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/tools/file_watchers",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/common",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/tools/file_watchers",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "//third_party/maven/org/mockito:mockito_core",
        "@WebStorm//:plugins/fileWatcher/lib/fileWatcher",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/util",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/javascript-openapi",
    ],
)
