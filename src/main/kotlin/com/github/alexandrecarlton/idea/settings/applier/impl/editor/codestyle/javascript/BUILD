load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "javascript",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/javascript",
        "//third_party/maven/javax/inject:javax_inject",
        "@idea-IC//:lib/platform-api",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/JavaScriptLanguage",
    ],
)
