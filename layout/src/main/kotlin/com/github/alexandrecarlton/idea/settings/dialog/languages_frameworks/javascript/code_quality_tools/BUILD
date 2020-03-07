load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "code_quality_tools",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks/javascript/code_quality_tools/eslint",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
    ],
)
