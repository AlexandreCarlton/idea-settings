load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "kotlin",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/blank_lines",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/code_generation",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/imports",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/tabs_and_indents",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/wrapping_and_braces",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
    ],
)
