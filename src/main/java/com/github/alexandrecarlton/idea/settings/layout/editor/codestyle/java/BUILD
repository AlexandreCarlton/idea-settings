java_library(
    name = "java",
    srcs = glob(["*.java"]),
    plugins = ["//third_party/maven/org/immutables:value_plugin"],
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/arrangement",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/blank_lines",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/imports",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/javadoc",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_databind",
        "//third_party/maven/org/immutables:value",
    ],
)
