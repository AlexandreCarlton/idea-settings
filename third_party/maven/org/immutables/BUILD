java_library(
    name = "value",
    exported_plugins = [
        ":value_plugin"
    ],
    exports = [
        "//external:jar/org/immutables/value"
    ],
    licenses = [
        "permissive"
    ],
    visibility = [
        "//visibility:public"
    ]
)
java_plugin(
    name = "value_plugin",
    deps = [
        "//external:jar/org/immutables/value"
    ],
    generates_api = True,
    licenses = [
        "permissive"
    ],
    processor_class = "org.immutables.processor.ProxyProcessor",
    visibility = [
        "//visibility:public"
    ]
)



