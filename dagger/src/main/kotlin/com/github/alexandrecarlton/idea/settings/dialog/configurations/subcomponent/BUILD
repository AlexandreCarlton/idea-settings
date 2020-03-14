load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "subcomponent",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//:dagger_with_compiler",
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/common/before_launch",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/intellij",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/common/before_launch",
    ],
)
