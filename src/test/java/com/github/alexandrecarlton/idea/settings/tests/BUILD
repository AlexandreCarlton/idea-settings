java_test(
    name = "tests",
    srcs = glob(["*.java"]),
    data = [
        "@javapoet",
        "@javapoet//:pom",
    ],
    jvm_flags = ["-Djavapoet.pom=$(rootpath @javapoet//:pom)"],
    test_class = "com.github.alexandrecarlton.idea.settings.tests.AllTests",
    runtime_deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/starter:lib/tools",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "@idea-IC//:lib/bootstrap",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/jna",
        "@idea-IC//:lib/log4j",
        "@idea-IC//:lib/trove4j",
        "@idea-IC//:lib/util",
    ],
    deps = [
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/codestyle/java",
        "//third_party/maven/junit",
    ],
)
