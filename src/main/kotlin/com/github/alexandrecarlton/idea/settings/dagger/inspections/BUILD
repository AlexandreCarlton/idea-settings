load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "inspections",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//:dagger_with_compiler",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/impl/editor/inspections/java/code_style_issues",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/inspections/java/code_style_issues",
        # Without the annotations library, we get warnings like:
        # warning: unknown enum constant Nls$Capitalization.Sentence
        "@idea-IC//:lib/annotations",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:plugins/java/lib/java-api",
        "@idea-IC//:plugins/java/lib/java-impl",
    ],
)
