load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "languages_frameworks",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/languages_frameworks",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/languages_frameworks/javascript",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/languages_frameworks/sql_dialects",
        "@maven//:javax_inject_javax_inject",
    ],
)
