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
    name = "plugins/Kotlin/lib/kotlin-formatter",
    jars = ["plugins/Kotlin/lib/kotlin-formatter.jar"],
    neverlink = True,
    srcjar = "@idea-IC-sources//jar",
)

java_import(
    name = "plugins/Kotlin/lib/kotlin-idea",
    jars = ["plugins/Kotlin/lib/kotlin-idea.jar"],
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

# We export dependencies if they appear in the main plugin's plugin.xml file as <dependency> elements.

java_import(
    name = "runtime",
    jars = glob(["lib/*.jar"]),
    srcjar = "@idea-IC-sources//jar",
    testonly = True,
)

java_import(
    name = "java_runtime",
    jars = glob(["plugins/java/**/*.jar"]),
    srcjar = "@idea-IC-sources//jar",
    exports = [":runtime"],
    testonly = True,
)

java_import(
    name = "Kotlin_runtime",
    jars = glob(["plugins/Kotlin/lib/**/*.jar"]),
    srcjar = "@idea-IC-sources//jar",
    exports = [
        ":runtime",
        ":java_runtime",
    ],
    testonly = True,
)

java_import(
    name = "properties_runtime",
    jars = glob(["plugins/properties/**/*.jar"]),
    srcjar = "@idea-IC-sources//jar",
    testonly = True,
)

java_import(
    name = "repository-search_runtime",
    jars = glob(["plugins/repository-search/**/*.jar"]),
    srcjar = "@idea-IC-sources//jar",
    testonly = True,
)

java_import(
    name = "maven_runtime",
    jars = glob(["plugins/maven/**/*.jar"]),
    exports = [
        ":runtime",
        ":java_runtime",
        ":maven-model_runtime",
        ":properties_runtime",
        ":repository-search_runtime",
    ],
    srcjar = "@idea-IC-sources//jar",
    testonly = True,
)

java_import(
    name = "maven-model_runtime",
    jars = glob(["plugins/maven-model/**/*.jar"]),
    exports = [":runtime"],
    srcjar = "@idea-IC-sources//jar",
    testonly = True,
)

java_import(
    name = "sh_runtime",
    jars = glob(["plugins/sh/**/*.jar"]),
    srcjar = "@idea-IC-sources//jar",
    exports = [":runtime"],
    testonly = True,
)
