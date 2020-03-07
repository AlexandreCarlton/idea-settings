load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "configurations",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/application",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/common/before_launch",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/docker",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/remote",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/shell_script",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/spring_boot",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
    ],
)
