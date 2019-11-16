java_library(
    name = "file_watchers",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/common",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/tools/file_watchers",
        "//third_party/maven/javax/inject:javax_inject",
        "@WebStorm//:plugins/fileWatcher/lib/fileWatcher",
        "@idea-IC//:lib/platform-api",
    ],
)
