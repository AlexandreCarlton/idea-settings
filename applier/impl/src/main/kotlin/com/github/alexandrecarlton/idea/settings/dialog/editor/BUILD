load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "editor",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/general",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/inspections",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/spelling",
        "@maven//:javax_inject_javax_inject",
    ],
)
