java_library(
    name = "checkstyle",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/other_settings/checkstyle",
        "//third_party/maven/javax/inject:javax_inject",
        "@CheckStyle-IDEA//:lib/checkstyle-idea",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/util",
    ],
)
