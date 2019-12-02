load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "checkstyle",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = ["//third_party/maven/com/fasterxml/jackson/core:jackson_annotations"],
)
