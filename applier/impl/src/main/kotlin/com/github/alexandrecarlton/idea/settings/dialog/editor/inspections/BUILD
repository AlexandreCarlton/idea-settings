load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "inspections",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/java",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/javascript",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/inspections/kotlin",
        "@maven//:javax_inject_javax_inject",
    ],
)
