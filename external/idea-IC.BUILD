package(default_visibility = ["//visibility:public"])
# vim:ft=bzl

exports_files([
    "bin/idea.sh",
    "bin/linux/idea64.vmoptions",
])

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
    name = "lib/json",
    jars = ["lib/json.jar"],
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
    name = "lib/platform-serviceContainer",
    jars = ["lib/platform-serviceContainer.jar"],
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
    name = "lib/testFramework",
    jars = ["lib/testFramework.jar"],
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
    name = "plugins/Kotlin/lib/kotlin-plugin",
    jars = ["plugins/Kotlin/lib/kotlin-plugin.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "plugins/markdown/lib/markdown",
    jars = ["plugins/markdown/lib/markdown.jar"],
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
    name = "plugins/sh/lib/sh",
    jars = ["plugins/sh/lib/sh.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "test_runtime_deps",
    jars = [
        "@local_jdk//:lib/tools.jar",
    ] + glob([
        "lib/*.jar",
        "plugins/java/**/*.jar",
        "plugins/Kotlin/lib/**/*.jar",
        "plugins/maven/**/*.jar",
        "plugins/properties/**/*.jar",
        "plugins/repository-search/**/*.jar",
        "plugins/sh/**/*.jar",
    ]),
    srcjar = "@idea-IC-sources//jar",
)
