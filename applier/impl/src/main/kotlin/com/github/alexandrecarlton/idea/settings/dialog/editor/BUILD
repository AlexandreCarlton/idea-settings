load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "editor",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/general",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/spelling",
        "@maven//:javax_inject_javax_inject",
    ],
)
