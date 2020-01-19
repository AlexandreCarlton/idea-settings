load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "inspections",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/inspections",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/inspections/java",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/editor/inspections/javascript",
        "@maven//:javax_inject_javax_inject",
    ],
)
