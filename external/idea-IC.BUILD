package(default_visibility = ["//visibility:public"])
# vim:ft=bzl

sh_binary(
    name = "bin/idea",
    srcs = ["bin/idea.sh"],
)

# We must neverlink all the libraries here; IntelliJ will manage this for us when we invoke idea.sh with idea-settings as a plugin.
java_import(
    name = "lib/annotations",
    jars = ["lib/annotations.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/bootstrap",
    jars = ["lib/bootstrap.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/extensions",
    jars = ["lib/extensions.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/idea",
    jars = ["lib/idea.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/jdom",
    jars = ["lib/jdom.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/jna",
    jars = ["lib/jna.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/log4j",
    jars = ["lib/log4j.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/openapi",
    jars = ["lib/openapi.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/platform-api",
    jars = ["lib/platform-api.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/platform-impl",
    jars = ["lib/platform-impl.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/platform-core-ui",
    jars = ["lib/platform-core-ui.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/platform-ide-util-io",
    jars = ["lib/platform-ide-util-io.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/platform-util-ex",
    jars = ["lib/platform-util-ex.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/platform-util-ui",
    jars = ["lib/platform-util-ui.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/spellchecker",
    jars = ["lib/spellchecker.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/trove4j",
    jars = ["lib/trove4j.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "lib/util",
    jars = ["lib/util.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "plugins/java/lib/java-api",
    jars = ["plugins/java/lib/java-api.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "plugins/java/lib/java-impl",
    jars = ["plugins/java/lib/java-impl.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "plugins/maven/lib/maven",
    jars = ["plugins/maven/lib/maven.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "test_runtime_deps",
    jars = [
        ":runtime_deps",
    ] + glob([
        "lib/*.jar",
        "plugins/java/**/*.jar",
    ]),
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "runtime_deps",
    jars = [
        # In idea.sh, these are added to the classpath.
        "lib/bootstrap.jar",
        "lib/extensions.jar",
        "lib/util.jar",
        "lib/log4j.jar",
        "lib/trove4j.jar",
        "lib/jna.jar",
        # In idea.sh, IDEA's own bundled tools.jar is provided,
        # but forces us to download officially released builds.
        "@local_jdk//:lib/tools.jar",
    ],
)
