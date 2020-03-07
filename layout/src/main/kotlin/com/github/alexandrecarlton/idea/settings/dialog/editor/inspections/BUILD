load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "inspections",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/java",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/javascript",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
    ],
)
