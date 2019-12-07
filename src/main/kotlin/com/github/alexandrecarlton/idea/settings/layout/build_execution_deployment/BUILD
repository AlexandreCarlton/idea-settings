load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "build_execution_deployment",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment/build_tools",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment/compiler",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_annotations",
    ],
)
