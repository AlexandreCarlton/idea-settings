load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "configurations",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations/application",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations/common/before_launch",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations/docker",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations/remote",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations/shell_script",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations/spring_boot",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
    ],
)
