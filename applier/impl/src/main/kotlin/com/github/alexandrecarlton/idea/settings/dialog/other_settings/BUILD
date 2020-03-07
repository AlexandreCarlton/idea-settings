load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "other_settings",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/other_settings",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/other_settings/checkstyle",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/other_settings/save_actions",
        "@maven//:javax_inject_javax_inject",
    ],
)
