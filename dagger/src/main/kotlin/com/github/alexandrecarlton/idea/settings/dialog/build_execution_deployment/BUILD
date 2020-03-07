load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "build_execution_deployment",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//:dagger_with_compiler",
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment",
    ],
)
