package(default_visibility = ["//visibility:public"])
# vim:ft=bzl:

java_import(
    name = "lib/checkstyle-idea",
    jars = glob(["lib/checkstyle-idea-*.jar"]),
    neverlink = True,
)

java_import(
    name = "runtime",
    jars = glob(["lib/*.jar"]),
    testonly = True,
)

filegroup(
    name = "lib/checkstyle-idea.jar",
    srcs = glob(["lib/checkstyle-idea-*.jar"]),
)
