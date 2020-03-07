load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "dialog",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/other_settings",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/project_settings",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/tools",
        "@maven//:javax_inject_javax_inject",
    ],
)
