test_suite(
    name = "file_watchers",
    tests = [
        ":file_watcher_settings_applier_test",
    ],
)

java_test(
    name = "file_watcher_settings_applier_test",
    srcs = ["FileWatcherSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.tools.file_watchers.FileWatcherSettingsApplierTest",
    runtime_deps = [
        "@WebStorm//:test_runtime_deps",
        "@idea-IC//:test_runtime_deps",
    ],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/tools/file_watchers",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/tools/file_watchers",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@WebStorm//:plugins/fileWatcher/lib/fileWatcher",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/util",
    ],
)
