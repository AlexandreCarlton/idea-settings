load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "tabs_and_indents",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/tabs_and_indents",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
        "@maven//:javax_inject_javax_inject",
    ],
)
