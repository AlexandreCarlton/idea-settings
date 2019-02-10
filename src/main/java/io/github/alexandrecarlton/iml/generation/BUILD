java_binary(
    name = "iml-generator",
    main_class = "io.github.alexandrecarlton.iml.generation.Main",
    visibility = ["//visibility:public"],
    runtime_deps = [
        ":generation",
    ],
)

java_library(
    name = "generation",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "@idea-IC//:lib/bootstrap",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/util",
        "@idea-IC//:lib/log4j",
        "@idea-IC//:lib/trove4j",
        "@idea-IC//:lib/jna",
        "@idea-IC//:jre64/lib/tools",

        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
    ],
)
