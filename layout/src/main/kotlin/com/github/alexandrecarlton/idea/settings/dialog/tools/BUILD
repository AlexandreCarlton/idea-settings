load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "tools",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/tools/file_watchers",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/tools/sonarlint",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
    ],
)
