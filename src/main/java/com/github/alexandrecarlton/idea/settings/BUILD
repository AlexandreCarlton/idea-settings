java_binary(
    name = "iml-generator",
    main_class = "com.github.alexandrecarlton.idea.settings.Main",
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
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/editor",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/editor/codestyle",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/editor/codestyle/java",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_core",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_databind",
        "//third_party/maven/com/fasterxml/jackson/dataformat:jackson_dataformat_yaml",
        "//third_party/maven/com/fasterxml/jackson/datatype:jackson_datatype_guava",
        "//third_party/maven/com/fasterxml/jackson/datatype:jackson_datatype_jdk8",
        "//third_party/maven/com/google/guava",
        "@idea-IC//:lib/bootstrap",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/java-impl",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
    ],
)
