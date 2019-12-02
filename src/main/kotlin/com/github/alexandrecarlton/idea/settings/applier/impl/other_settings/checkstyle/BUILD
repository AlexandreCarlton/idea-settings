load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "checkstyle",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/other_settings/checkstyle",
        "//third_party/maven/javax/inject:javax_inject",
        "@CheckStyle-IDEA//:lib/checkstyle-idea",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
    ],
)
