java_library(
    name = "config",
    srcs = glob(["*.java"]),
    plugins = [":immutables_plugin"],
    visibility = ["//visibility:public"],
    deps = [
        "@com_fasterxml_jackson_core_jackson_annotations//jar",
        "@com_fasterxml_jackson_core_jackson_databind//jar",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/java-impl",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
        "@org_immutables_value//jar",
    ],
)

java_plugin(
    name = "immutables_plugin",
    generates_api = True,
    processor_class = "org.immutables.processor.ProxyProcessor",
    visibility = ["//visibility:public"],
    deps = [
        "@com_fasterxml_jackson_core_jackson_annotations//jar",
        "@com_fasterxml_jackson_core_jackson_databind//jar",
        "@org_immutables_value//jar",
    ],
)
