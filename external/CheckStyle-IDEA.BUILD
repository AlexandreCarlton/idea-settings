package(default_visibility = ["//visibility:public"])
# vim:ft=bzl:

java_import(
    name = "lib/checkstyle-idea",
    jars = glob(["lib/checkstyle-idea-*.jar"]),
    neverlink = True,
)

java_import(
    name = "test_runtime_deps",
    jars = glob(["lib/*.jar"]),
)

filegroup(
    name = "lib/checkstyle-idea.jar",
    srcs = glob(["lib/checkstyle-idea-*.jar"]),
)
