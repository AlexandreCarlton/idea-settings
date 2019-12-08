load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "sql_dialects",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/languages_frameworks/sql_dialects",
        "@maven//:javax_inject_javax_inject",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
        "@idea-IU//:plugins/DatabaseTools/lib/database-dialects",
        "@idea-IU//:plugins/DatabaseTools/lib/database-impl",
        "@idea-IU//:plugins/DatabaseTools/lib/database-openapi",
    ],
)
