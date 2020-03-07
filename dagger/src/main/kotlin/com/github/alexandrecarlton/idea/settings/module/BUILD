load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "module",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//:dagger_with_compiler",
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/project_settings/modules",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/project_settings/modules",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/project_settings/modules",
        "@idea-IC//:lib/platform-api",
    ],
)
