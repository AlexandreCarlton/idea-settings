load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "filetype",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//:dagger_with_compiler",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/common/filetype",
        # Adding @idea-IC//:lib/annotations quashes the following error:
        # warning: warning: unknown enum constant Nls$Capitalization.Sentence
        #  reason: class file for org.jetbrains.annotations.Nls$Capitalization not found
        "@idea-IC//:lib/annotations",
        "@idea-IC//:lib/platform-api",
    ],
)
