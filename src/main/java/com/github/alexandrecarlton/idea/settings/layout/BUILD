java_library(
    name = "layout",
    srcs = glob(["*.java"]),
    plugins = ["//third_party/maven/org/immutables:value_plugin"],
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/configurations",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/languages_frameworks",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/other_settings",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/project_settings",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_databind",
        "@org_immutables_value//jar",
    ],
)
