load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "project_settings",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/project_settings/modules",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/project_settings/project",
    ],
)
