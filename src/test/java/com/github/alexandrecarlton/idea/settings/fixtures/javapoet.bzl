"""
A convience macro around java_test for test classes that inherit from JavapoetTestFixture.
"""

def java_test_javapoet(name, srcs, test_class, deps, size = "medium"):
    native.java_test(
        name = name,
        size = size,
        srcs = srcs,
        data = [
            "@javapoet",
            "@javapoet//:pom",
        ],
        jvm_flags = ["-Djavapoet.pom=$(rootpath @javapoet//:pom)"],
        test_class = test_class,
        runtime_deps = [
            "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
            "@idea-IC//:runtime_deps",
        ],
        deps = deps,
    )
