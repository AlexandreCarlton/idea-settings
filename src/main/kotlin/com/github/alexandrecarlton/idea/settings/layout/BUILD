load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "layout",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/languages_frameworks",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/other_settings",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/project_settings",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/tools",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_annotations",
    ],
)
