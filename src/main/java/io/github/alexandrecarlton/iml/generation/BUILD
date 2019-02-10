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
        "@idea-IC//:bootstrap",
        "@idea-IC//:extensions",
        "@idea-IC//:util",
        "@idea-IC//:log4j",
        "@idea-IC//:trove4j",
        "@idea-IC//:jna",
        "@idea-IC//:tools",

        "@idea-IC//:platform-api",
        "@idea-IC//:platform-impl",
    ],
)
