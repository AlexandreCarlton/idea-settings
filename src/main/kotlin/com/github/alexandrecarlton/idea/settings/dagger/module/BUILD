load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "module",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/project_settings/modules",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/project_settings/modules",
        "//:dagger_with_compiler",
        "@idea-IC//:lib/platform-api",
    ],
)
