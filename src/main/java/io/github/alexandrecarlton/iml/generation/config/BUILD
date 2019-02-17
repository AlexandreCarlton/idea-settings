java_library(
    name = "config",
    srcs = glob(["*.java"]),
    plugins = ["//third_party/maven/org/immutables:value_plugin"],
    visibility = ["//visibility:public"],
    deps = [
        "//third_party/maven/com/fasterxml/jackson/core:jackson_annotations",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_databind",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/java-impl",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
        "@org_immutables_value//jar",
    ],
)
