load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "tools",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/tools",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/tools/file_watchers",
        "//third_party/maven/javax/inject:javax_inject",
    ],
)
