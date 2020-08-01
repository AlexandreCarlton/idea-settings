package(default_visibility = ["//visibility:public"])
# vim:ft=bzl

exports_files([
    "lib/fileWatcher.jar",
    "lib/resources_en.jar",
])

java_import(
    name = "lib/fileWatcher",
    jars = ["lib/fileWatcher.jar"],
    neverlink = True,
)

java_import(
    name = "runtime",
    testonly = True,
    jars = glob(["lib/*.jar"]),
)
