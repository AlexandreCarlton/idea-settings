package(default_visibility = ["//visibility:public"])
# vim:ft=bzl:

java_import(
    name = "lib/sonarlint-intellij",
    jars = glob(["lib/sonarlint-intellij-*.jar"]),
    neverlink = True,
)

java_import(
    name = "runtime",
    testonly = True,
    jars = glob(["lib/*.jar"]),
)

filegroup(
    name = "lib/sonarlint-intellij.jar",
    srcs = glob(["lib/sonarlint-intellij-*.jar"]),
)

filegroup(
    name = "lib/sonarlint-client-api.jar",
    srcs = glob(["lib/sonarlint-client-api-*.jar"]),
)

filegroup(
    name = "lib/sonarlint-core.jar",
    srcs = glob(["lib/sonarlint-core-*.jar"]),
)
