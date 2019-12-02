load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "java",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/arrangement",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/blank_lines",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/imports",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/javadoc",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/wrapping_and_braces",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_annotations",
    ],
)
