load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "file_watchers",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/common",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/tools/file_watchers",
        "@maven//:javax_inject_javax_inject",
        "@WebStorm//:plugins/fileWatcher/lib/fileWatcher",
        "@idea-IC//:lib/platform-api",
    ],
)
