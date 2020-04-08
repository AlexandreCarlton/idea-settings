load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "code_generation",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//:dagger_with_compiler",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/code_generation",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/common",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/code_generation",
    ],
)
