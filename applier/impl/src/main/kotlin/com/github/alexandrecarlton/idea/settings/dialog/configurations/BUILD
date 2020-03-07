load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "configurations",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/configuration",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/common/before_launch",
        "@maven//:javax_inject_javax_inject",
        "@idea-IC//:lib/platform-api",
    ],
)
