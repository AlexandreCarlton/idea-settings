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
        "//third_party/maven/com/fasterxml/jackson/core:jackson_core",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_databind",
        "//third_party/maven/com/fasterxml/jackson/dataformat:jackson_dataformat_yaml",
        "//third_party/maven/com/fasterxml/jackson/datatype:jackson_datatype_guava",
        "//third_party/maven/com/fasterxml/jackson/datatype:jackson_datatype_jdk8",
        "//third_party/maven/com/google/guava",
        "//src/main/java/io/github/alexandrecarlton/iml/generation/config",
        "@idea-IC//:lib/bootstrap",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/java-impl",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
    ],
)
