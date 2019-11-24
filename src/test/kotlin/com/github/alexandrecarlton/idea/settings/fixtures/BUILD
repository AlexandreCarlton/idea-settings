load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "fixtures",
    testonly = True,
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "//third_party/maven/org/mockito:mockito_core",
        "//third_party/maven/org/xmlunit:xmlunit_assertj",
        "@idea-IC//:lib/idea",
        "@idea-IC//:lib/platform-api",
    ],
)
