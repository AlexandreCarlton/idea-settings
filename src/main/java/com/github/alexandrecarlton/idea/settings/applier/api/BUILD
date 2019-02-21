java_library(
    name = "api",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    # TODO: We can get rid of this completely if we dependency-inject Project.
    deps = [
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/java-impl",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
    ],
)
