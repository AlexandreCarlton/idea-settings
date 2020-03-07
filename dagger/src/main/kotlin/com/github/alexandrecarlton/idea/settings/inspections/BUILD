load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "inspections",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//:dagger_with_compiler",
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/java/code_style_issues",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/java/javadoc",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/java/probable_bugs",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/javascript/code_quality_tools",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/inspections/java/code_style_issues",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/inspections/java/javadoc",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/inspections/java/probable_bugs",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/inspections/javascript/code_quality_tools",
        # Without the annotations library, we get warnings like:
        # warning: unknown enum constant Nls$Capitalization.Sentence
        "@idea-IC//:lib/annotations",
        "@idea-IC//:lib/util",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:plugins/java/lib/java-api",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/JavaScriptLanguage",
    ],
)
