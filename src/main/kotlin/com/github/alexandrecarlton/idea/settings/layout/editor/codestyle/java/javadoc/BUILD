load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "javadoc",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = ["@maven//:com_fasterxml_jackson_core_jackson_annotations"],
)
