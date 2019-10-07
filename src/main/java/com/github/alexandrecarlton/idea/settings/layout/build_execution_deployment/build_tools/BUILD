java_library(
    name = "build_tools",
    srcs = glob(["*.java"]),
    plugins = ["//third_party/maven/org/immutables:value_plugin"],
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment/build_tools/maven",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_databind",
        "//third_party/maven/org/immutables:value",
    ],
)
