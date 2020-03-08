load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "intellij",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//:dagger_with_compiler",
        # Without the annotations library, we get warnings like:
        # warning: unknown enum constant Nls$Capitalization.Sentence
        "@idea-IC//:lib/annotations",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@idea-IC//:plugins/java/lib/java-api",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/JavaScriptLanguage",
    ],
)
