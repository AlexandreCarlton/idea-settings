load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "checkstyle",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/other_settings/checkstyle",
        "@maven//:javax_inject_javax_inject",
        "@CheckStyle-IDEA//:lib/checkstyle-idea",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
    ],
)
