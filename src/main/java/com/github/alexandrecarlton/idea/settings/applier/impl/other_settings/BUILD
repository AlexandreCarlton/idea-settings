load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "other_settings",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/other_settings",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/other_settings/checkstyle",
        "//third_party/maven/javax/inject:javax_inject",
    ],
)
