load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "codestyle",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/javascript",
    ],
)
