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
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "@idea-IC//:runtime_deps",
    ],
    deps = [
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/codestyle/java",
        "//third_party/maven/junit",
    ],
)
