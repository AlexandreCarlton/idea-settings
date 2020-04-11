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

java_import(
    name = "runtime",
    testonly = True,
    jars = ["@local_jdk//:lib/tools.jar"] + glob(["lib/*.jar"]),
)

java_import(
    name = "CSS_runtime",
    testonly = True,
    jars = glob(["plugins/CSS/**/*.jar"]),
    exports = [
        ":platform-images_runtime",
    ],
)

java_import(
    name = "DatabaseTools_runtime",
    testonly = True,
    jars = glob(["plugins/DatabaseTools/**/*.jar"]),
    exports = [":runtime"],
)

java_import(
    name = "Docker_runtime",
    testonly = True,
    jars = glob(["plugins/Docker/**/*.jar"]),
    exports = [":runtime"],
)

java_import(
    name = "java_runtime",
    testonly = True,
    jars = glob(["plugins/java/**/*.jar"]),
    exports = [
        ":runtime",
    ],
)

java_import(
    name = "java-i18n_runtime",
    testonly = True,
    jars = glob(["plugins/java-i18n/**/*.jar"]),
    exports = [
        ":java_runtime",
        ":runtime",
    ],
)

# Probably gonna need to fill out this one, here.
java_import(
    name = "JavaScriptLanguage_runtime",
    testonly = True,
    jars = glob(["plugins/JavaScriptLanguage/**/*.jar"]),
    exports = [
        ":CSS_runtime",
        ":runtime",
    ],
)

java_import(
    name = "frameworks-starters_runtime",
    testonly = True,
    jars = glob(["plugins/frameworks-starters/**/*.jar"]),
    exports = [
        ":java_runtime",
    ],
)

java_import(
    name = "microservices-config_runtime",
    testonly = True,
    jars = glob(["plugins/microservices-config/**/*.jar"]),
    exports = [
        ":java_runtime",
        ":properties_runtime",
    ],
)

java_import(
    name = "platform-images_runtime",
    testonly = True,
    jars = glob(["plugins/platform-images/**/*.jar"]),
)

java_import(
    name = "properties_runtime",
    testonly = True,
    jars = glob(["plugins/properties/**/*.jar"]),
)

java_import(
    name = "Spring_runtime",
    testonly = True,
    jars = glob(["plugins/Spring/**/*.jar"]),
    exports = [
        ":java-i18n_runtime",
        ":properties_runtime",
        ":runtime",
    ],
)

java_import(
    name = "SpringBoot_runtime",
    testonly = True,
    jars = glob(["plugins/SpringBoot/**/*.jar"]),
    exports = [
        ":Spring_runtime",
        ":frameworks-starters_runtime",
        ":microservices-config_runtime",
        ":runtime",
    ],
)
