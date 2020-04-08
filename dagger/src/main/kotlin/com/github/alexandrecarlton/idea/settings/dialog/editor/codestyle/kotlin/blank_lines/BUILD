load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "blank_lines",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//:dagger_with_compiler",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/blank_lines",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/common",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/blank_lines",
    ],
)
