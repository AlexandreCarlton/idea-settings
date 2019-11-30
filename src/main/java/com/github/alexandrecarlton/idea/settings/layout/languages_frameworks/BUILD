load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "languages_frameworks",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/languages_frameworks/javascript",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/languages_frameworks/sql_dialects",
    ],
)
