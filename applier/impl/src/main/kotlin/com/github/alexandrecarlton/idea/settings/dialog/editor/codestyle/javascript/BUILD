load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "javascript",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/javascript",
        "@maven//:javax_inject_javax_inject",
        "@idea-IC//:lib/platform-api",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/JavaScriptLanguage",
    ],
)
