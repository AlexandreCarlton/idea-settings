load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "javascript",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/inspections/javascript",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/inspections/javascript/code_quality_tools",
        "@maven//:javax_inject_javax_inject",
    ],
)
