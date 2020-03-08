load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "subcomponent",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//:dagger_with_compiler",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/java/code_style_issues/options",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/java/javadoc/options",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/java/probable_bugs/options",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/javascript/code_quality_tools/options",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/options",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/intellij",
        # Without the annotations library, we get warnings like:
        # warning: unknown enum constant Nls$Capitalization.Sentence
        "@idea-IC//:lib/annotations",
        "@idea-IC//:lib/platform-api",
    ],
)
