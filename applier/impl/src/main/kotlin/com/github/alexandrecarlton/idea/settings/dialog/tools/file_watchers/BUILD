load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "file_watchers",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/tools/file_watchers",
        "@File-Watchers//:lib/fileWatcher",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
        "@maven//:javax_inject_javax_inject",
    ],
)
