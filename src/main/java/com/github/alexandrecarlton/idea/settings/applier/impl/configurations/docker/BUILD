java_library(
    name = "docker",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/configurations",
        "//third_party/maven/javax/inject:javax_inject",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IU//:plugins/Docker/lib/Docker-agent-api-rt",
        "@idea-IU//:plugins/Docker/lib/Docker-core",
        "@idea-IU//:plugins/Docker/lib/Docker-remote-run",
    ],
)
