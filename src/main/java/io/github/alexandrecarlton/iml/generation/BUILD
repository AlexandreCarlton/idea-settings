java_binary(
    name = "iml-generator",
    main_class = "io.github.alexandrecarlton.iml.generation.Main",
    visibility = ["//visibility:public"],
    runtime_deps = [
        ":generation",

        # In idea.sh, these are added to the classpath.
        "@idea-IC//:lib/bootstrap",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/util",
        "@idea-IC//:lib/log4j",
        "@idea-IC//:lib/trove4j",
        "@idea-IC//:lib/jna",
        "@idea-IC//:jre64/lib/tools",
    ],
)

java_library(
    name = "generation",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/io/github/alexandrecarlton/iml/generation/config",
        "@com_fasterxml_jackson_core_jackson_core//jar",
        "@com_fasterxml_jackson_core_jackson_databind//jar",
        "@com_fasterxml_jackson_dataformat_jackson_dataformat_yaml//jar",
        "@com_fasterxml_jackson_datatype_jackson_datatype_guava//jar",
        "@com_fasterxml_jackson_datatype_jackson_datatype_jdk8//jar",
        "@com_google_guava_guava//jar",
        "@idea-IC//:lib/bootstrap",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/java-impl",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
    ],
)
