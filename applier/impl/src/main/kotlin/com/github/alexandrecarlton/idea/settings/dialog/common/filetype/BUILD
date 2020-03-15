load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "filetype",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/common/filetype",
        "@idea-IC//:lib/platform-api",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/javascript-openapi",
        "@maven//:javax_inject_javax_inject",
    ],
)
