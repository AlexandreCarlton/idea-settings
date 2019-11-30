load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "impl",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/configurations",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/languages_frameworks",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/other_settings",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/project_settings",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/tools",
        "//third_party/maven/javax/inject:javax_inject",
    ],
)
