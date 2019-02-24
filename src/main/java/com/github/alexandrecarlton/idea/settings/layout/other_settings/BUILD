java_library(
    name = "other_settings",
    srcs = glob(["*.java"]),
    plugins = ["//third_party/maven/org/immutables:value_plugin"],
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/other_settings/checkstyle",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_databind",
        "@org_immutables_value//jar",
    ],
)
