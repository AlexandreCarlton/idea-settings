load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "tools",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/tools",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/tools/file_watchers",
        "@maven//:javax_inject_javax_inject",
    ],
)
