load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive", "http_jar")

# To consult further release: https://www.jetbrains.com/intellij-repository/releases/
IDEA_IC_VERSION = "2018.3.3"
IDEA_IC_PREFIX = "idea-IC-183.5153.38"
IDEA_IC_SHA256 = "15f9676c7807e9f3e462500c5fefd4de543ed5804c588bbb3719dbd94e1d3db1"
IDEA_IC_SOURCES_SHA256 = "276e548135d2c9d5a4a0880dead9a0f48aecdfd1e78074a3c0d48cb2575ad6a0"

http_archive(
    name = "idea-IC",
    build_file = "idea-IC.BUILD",
    sha256 = IDEA_IC_SHA256,
    strip_prefix = IDEA_IC_PREFIX,
    # We don't pull from the same place we get the sources jar because it does not contain a bundled JRE (which is necessary to work properly).
    # If we can find another tools.jar to use, we can use the same url as sources.
    url = "https://download.jetbrains.com/idea/ideaIC-{0}.tar.gz".format(IDEA_IC_VERSION),
)

http_jar(
    name = "idea-IC-sources",
    sha256 = IDEA_IC_SOURCES_SHA256,
    url = "https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC/{0}/ideaIC-{0}-sources.jar".format(IDEA_IC_VERSION),
)

maven_jar(
    name = "org_immutables_value",
    artifact = "org.immutables:value:2.7.4",
)

maven_jar(
    name = "com_google_guava_guava",
    artifact = "com.google.guava:guava:27.0.1-jre",
)

maven_jar(
    name = "com_fasterxml_jackson_dataformat_jackson_dataformat_yaml",
    artifact = "com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.9.8",
)

maven_jar(
    name = "com_fasterxml_jackson_datatype_jackson_datatype_guava",
    artifact = "com.fasterxml.jackson.datatype:jackson-datatype-guava:2.9.8",
)

maven_jar(
    name = "com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
    artifact = "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.9.8",
)

maven_jar(
    name = "com_fasterxml_jackson_core_jackson_core",
    artifact = "com.fasterxml.jackson.core:jackson-core:2.9.8",
)

maven_jar(
    name = "com_fasterxml_jackson_core_jackson_databind",
    artifact = "com.fasterxml.jackson.core:jackson-databind:2.9.8",
)

maven_jar(
    name = "com_fasterxml_jackson_core_jackson_annotations",
    artifact = "com.fasterxml.jackson.core:jackson-annotations:2.9.8",
)
