package(default_visibility = ["//visibility:public"])
# vim:ft=bzl

exports_files([
    "bin/idea.sh",
    "bin/linux/idea64.vmoptions",
])

java_import(
    name = "test_runtime_deps",
    jars = [
        "@local_jdk//:lib/tools.jar",
    ] + glob([
        "lib/*.jar",
        "plugins/java/**/*.jar",
        "plugins/maven/**/*.jar",
        "plugins/properties/**/*.jar",
    ]),
)
