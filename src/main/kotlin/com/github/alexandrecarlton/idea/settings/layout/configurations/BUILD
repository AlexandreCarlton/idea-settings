load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "configurations",
    # Having ConfigurationSettings be the parent of *Settings.java
    # but also reference them in JsonSubType annotations creates a circular dependency.
    srcs = glob(["**/*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations/common/before_launch",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
    ],
)
