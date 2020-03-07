load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "plugin",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/module",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/project",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_dataformat_jackson_dataformat_yaml",
        "@maven//:com_fasterxml_jackson_datatype_jackson_datatype_guava",
        "@maven//:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "@maven//:com_fasterxml_jackson_module_jackson_module_kotlin",
        "@maven//:javax_inject_javax_inject",
    ],
)
