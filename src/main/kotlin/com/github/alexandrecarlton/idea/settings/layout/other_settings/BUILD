load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "other_settings",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/other_settings/checkstyle",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/other_settings/save_actions",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
    ],
)
