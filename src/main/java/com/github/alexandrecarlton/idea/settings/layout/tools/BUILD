java_library(
    name = "tools",
    srcs = glob(["*.java"]),
    plugins = ["//third_party/maven/org/immutables:value_plugin"],
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/tools/file_watchers",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_databind",
        "//third_party/maven/org/immutables:value",
    ],
)
