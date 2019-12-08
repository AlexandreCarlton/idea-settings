load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "project_settings",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/dagger/module",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/project_settings",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/project_settings/modules",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/project_settings/project",
        "@maven//:javax_inject_javax_inject",
        "@idea-IC//:lib/platform-api",
    ],
)
