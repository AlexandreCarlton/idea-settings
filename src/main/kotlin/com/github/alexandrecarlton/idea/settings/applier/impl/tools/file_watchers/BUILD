load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "file_watchers",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/common",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/tools/file_watchers",
        "//third_party/maven/javax/inject:javax_inject",
        "@WebStorm//:plugins/fileWatcher/lib/fileWatcher",
        "@idea-IC//:lib/platform-api",
    ],
)
