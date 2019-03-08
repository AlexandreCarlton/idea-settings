# TODO:
# Just create libraries here,
# And in test/.../starter, add the java_test rule which will collect everything.
# Also, in starter, create a generic abstract IdeaSettingsTestCase, referencing a repository and w/e,
# and then have another abstract JavapoetTest which fills in the getRepository() { System.getProperty(javapoet.pom).gatParent.. }
# Makes things marginally easier.
# Seems like this should be parametrisable.
# So in JUnit4 this looks kind of straightforward, with JUnit5 we'd need @MethodSource. Seems fine.
java_test(
    name = "TestJavaImportSettingsApplier",
    srcs = ["TestJavaImportSettingsApplier.java"],
    data = [
        "@javapoet",
        "@javapoet//:pom",
    ],
    jvm_flags = ["-Djavapoet.pom=$(rootpath @javapoet//:pom)"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.editor.codestyle.java.TestJavaImportSettingsApplier",
    runtime_deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/starter:lib/tools",
        "@idea-IC//:lib/bootstrap",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/jna",
        "@idea-IC//:lib/log4j",
        "@idea-IC//:lib/trove4j",
        "@idea-IC//:lib/util",
    ],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/starter",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/xmlunit:xmlunit_assertj",
    ],
    visibility = ["//visibility:public"],
)
