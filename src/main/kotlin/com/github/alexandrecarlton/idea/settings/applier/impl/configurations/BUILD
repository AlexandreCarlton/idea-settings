load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "configurations",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/dagger/configuration",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations/common/before_launch",
        "//third_party/maven/javax/inject:javax_inject",
        "@idea-IC//:lib/platform-api",
    ],
)
