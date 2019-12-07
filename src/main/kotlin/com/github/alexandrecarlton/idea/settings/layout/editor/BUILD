load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "editor",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/general",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/spelling",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_annotations",
    ],
)
