load(
    "@intellij_with_bazel//build_defs:build_defs.bzl",
    "intellij_plugin",
    "intellij_plugin_library",
)

intellij_plugin_library(
    name = "plugin_library",
    plugin_xmls = ["src/main/resources/META-INF/plugin.xml"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/starter",
    ],
)

filegroup(
    name = "plugin_xml",
    srcs = ["plugin.xml"],
    visibility = ["//visibility:public"],
)

intellij_plugin(
    name = "idea-settings",
    plugin_xml = ":plugin_xml",
    deps = [":plugin_library"],
)

sh_binary(
    name = "apply-idea-settings",
    srcs = ["apply-idea-settings.sh"],
    deps = ["@bazel_tools//tools/bash/runfiles"],
    data = [
        ":idea-settings",
        "@idea-IC//:bin/idea",
        "@CheckStyle-IDEA//:lib/checkstyle-idea_jar",
    ],
)

test_suite(
    name = "tests",
    tests = [
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment/compiler",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/codestyle/java",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/general/auto_import",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/spelling",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/other_settings/checkstyle",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/project_settings/project",
    ],
)
