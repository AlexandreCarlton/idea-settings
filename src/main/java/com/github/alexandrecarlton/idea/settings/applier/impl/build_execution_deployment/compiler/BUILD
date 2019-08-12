java_library(
    name = "compiler",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment/compiler",
        "//third_party/maven/javax/inject:javax_inject",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/openapi",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/java/lib/java-api",
    ],
)
