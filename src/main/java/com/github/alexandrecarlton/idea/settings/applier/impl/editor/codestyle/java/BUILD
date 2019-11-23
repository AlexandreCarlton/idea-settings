java_library(
    name = "java",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/arrangement",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/blank_lines",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/imports",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/editor/codestyle/java/javadoc",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/javax/inject:javax_inject",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/java/lib/java-api",
        "@idea-IC//:plugins/java/lib/java-impl",
    ],
)
