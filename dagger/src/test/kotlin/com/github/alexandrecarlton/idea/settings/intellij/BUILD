load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "intellij",
    testonly = True,
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        # TODO: Work out why we don't need to specify @idea-IC//:... libs.
        "//:dagger_with_compiler",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/intellij",
    ],
)
