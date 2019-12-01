load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "configuration",
    srcs = glob(["*.kt"]),
    plugins = ["//third_party/maven/com/google/dagger:dagger_compiler_plugin"],
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/configurations/common/before_launch",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/dagger/common",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/configurations/common/before_launch",
        "//third_party/maven/com/google/dagger",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/platform-serviceContainer",
        "@idea-IC//:lib/util",
    ],
)
