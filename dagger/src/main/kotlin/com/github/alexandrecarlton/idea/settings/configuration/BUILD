load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "configuration",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/common/before_launch",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/common",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations/common/before_launch",
        "//:dagger_with_compiler",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/platform-serviceContainer",
        "@idea-IC//:lib/util",
    ],
)
