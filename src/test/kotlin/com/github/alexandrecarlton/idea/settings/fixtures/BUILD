load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "fixtures",
    testonly = True,
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
        "@maven//:org_mockito_mockito_core",
        "@maven//:org_xmlunit_xmlunit_assertj",
        "@idea-IC//:lib/idea",
        "@idea-IC//:lib/platform-api",
    ],
)
