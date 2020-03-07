load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "java",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/java",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/java/code_style_issues",
        "@maven//:javax_inject_javax_inject",
    ],
)
