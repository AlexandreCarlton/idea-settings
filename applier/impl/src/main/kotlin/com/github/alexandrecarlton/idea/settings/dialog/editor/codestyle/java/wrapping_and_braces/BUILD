load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "wrapping_and_braces",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/java/wrapping_and_braces",
        "@maven//:javax_inject_javax_inject",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:plugins/java/lib/java-impl",
    ],
)
