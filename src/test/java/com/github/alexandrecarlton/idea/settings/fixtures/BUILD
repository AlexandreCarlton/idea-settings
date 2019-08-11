java_library(
    name = "fixtures",
    testonly = True,
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/starter",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "//third_party/maven/org/mockito:mockito_core",
        "//third_party/maven/org/xmlunit:xmlunit_assertj",
        "@idea-IC//:lib/bootstrap",
        "@idea-IC//:lib/idea",
        "@idea-IC//:lib/java-impl",
        "@idea-IC//:lib/platform-api",
    ],
)
