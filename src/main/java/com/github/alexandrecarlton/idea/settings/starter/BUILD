load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "starter",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/dagger/module",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/dagger/project",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_core",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_databind",
        "//third_party/maven/com/fasterxml/jackson/dataformat:jackson_dataformat_yaml",
        "//third_party/maven/com/fasterxml/jackson/datatype:jackson_datatype_guava",
        "//third_party/maven/com/fasterxml/jackson/datatype:jackson_datatype_jdk8",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
    ],
)
