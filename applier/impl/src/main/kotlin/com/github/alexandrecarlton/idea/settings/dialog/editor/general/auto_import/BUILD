load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "auto_import",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/general/auto_import",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:plugins/Kotlin/lib/kotlin-idea",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@maven//:javax_inject_javax_inject",
    ],
)
