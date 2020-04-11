package(default_visibility = ["//visibility:public"])
# vim:ft=bzl

exports_files([
    "bin/webstorm.sh",
    "bin/webstorm64.vmoptions",
    "plugins/fileWatcher/lib/fileWatcher.jar",
    "plugins/fileWatcher/lib/resources_en.jar",
])

java_import(
    name = "plugins/fileWatcher/lib/fileWatcher",
    jars = ["plugins/fileWatcher/lib/fileWatcher.jar"],
    neverlink = True,
)

java_import(
    name = "fileWatcher_runtime",
    testonly = True,
    jars = glob(["plugins/fileWatcher/**/*.jar"]),
    exports = ["@idea-IU//:runtime"],
)
