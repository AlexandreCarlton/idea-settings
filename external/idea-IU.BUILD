package(default_visibility = ["//visibility:public"])
# vim:ft=bzl

exports_files([
    "bin/idea.sh",
    "bin/linux/idea64.vmoptions",
])

java_import(
    name = "plugins/CSS/lib/css",
    jars = ["plugins/CSS/lib/css.jar"],
    neverlink = True,
)

java_import(
    name = "plugins/CSS/lib/css-openapi",
    jars = ["plugins/CSS/lib/css-openapi.jar"],
    neverlink = True,
)

java_import(
    name = "plugins/DatabaseTools/lib/database-dialects",
    jars = ["plugins/DatabaseTools/lib/database-dialects.jar"],
    neverlink = True,
)

java_import(
    name = "plugins/DatabaseTools/lib/database-impl",
    jars = ["plugins/DatabaseTools/lib/database-impl.jar"],
    neverlink = True,
)

java_import(
    name = "plugins/DatabaseTools/lib/database-openapi",
    jars = ["plugins/DatabaseTools/lib/database-openapi.jar"],
    neverlink = True,
)

java_import(
    name = "plugins/Docker/lib/Docker-agent-api-rt",
    jars = ["plugins/Docker/lib/Docker-agent-api-rt.jar"],
    neverlink = True,
)

java_import(
    name = "plugins/Docker/lib/Docker-core",
    jars = ["plugins/Docker/lib/Docker-core.jar"],
    neverlink = True,
)

java_import(
    name = "plugins/Docker/lib/Docker-remote-run",
    jars = ["plugins/Docker/lib/Docker-remote-run.jar"],
    neverlink = True,
)

java_import(
    name = "plugins/JavaScriptLanguage/lib/JavaScriptLanguage",
    jars = ["plugins/JavaScriptLanguage/lib/JavaScriptLanguage.jar"],
    neverlink = True,
)

java_import(
    name = "plugins/JavaScriptLanguage/lib/javascript-openapi",
    jars = ["plugins/JavaScriptLanguage/lib/javascript-openapi.jar"],
    neverlink = True,
)

java_import(
    name = "plugins/less/lib/less",
    jars = ["plugins/less/lib/less.jar"],
    neverlink = True,
)

java_import(
    name = "plugins/SpringBoot/lib/spring-boot-run",
    jars = ["plugins/SpringBoot/lib/spring-boot-run.jar"],
    neverlink = True,
)

java_import(
    name = "plugins/SpringBoot/lib/spring-boot",
    jars = ["plugins/SpringBoot/lib/spring-boot.jar"],
    neverlink = True,
)

# TODO: Separate these into targets like "JavaScriptLanguage_runtime" and "SpringBoot_runtime"
# This way, we have a lower chance of having weird classpath collisions in our unit tests.
java_import(
    name = "test_runtime_deps",
    jars = [
        "@local_jdk//:lib/tools.jar",
    ] + glob([
        "lib/*.jar",
        "plugins/java/**/*.jar",
        "plugins/java-i18n/**/*.jar",
        "plugins/maven/**/*.jar",
        "plugins/properties/**/*.jar",
        "plugins/repository-search/**/*.jar",
        "plugins/JavaScriptLanguage/**/*.jar",
        "plugins/CSS/**/*.jar",
        "plugins/DatabaseTools/**/*.jar",
        "plugins/Docker/**/*.jar",
        "plugins/platform-images/**/*.jar",
        "plugins/frameworks-starters/**/*.jar",
        "plugins/microservices-config/**/*.jar",
        "plugins/SpringBoot/**/*.jar",
        "plugins/Spring/**/*.jar",
    ]),
)
