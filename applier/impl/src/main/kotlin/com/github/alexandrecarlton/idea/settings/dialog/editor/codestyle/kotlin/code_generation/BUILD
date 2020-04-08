load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "code_generation",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/code_generation",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:plugins/Kotlin/lib/kotlin-plugin",
        "@maven//:javax_inject_javax_inject",
    ],
)
