package(default_visibility = ["//visibility:public"])

load(
    "@intellij_with_bazel//build_defs:build_defs.bzl",
    "intellij_plugin",
    "intellij_plugin_library",
)
load("@rules_pkg//:pkg.bzl", "pkg_tar")

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

pkg_tar(
    name = "plugins",
    srcs = [
        ":idea-settings",
        "@CheckStyle-IDEA//:lib/checkstyle-idea.jar",
    ],
)

# For some reason referencing :plugins in sh_binary doesn't work;
# however, creating a filegroup and referencing that does.
# See https://github.com/bazelbuild/bazel/pull/6352
filegroup(
    name = "plugins_tar",
    srcs = [":plugins"],
)

sh_binary(
    name = "apply-idea-settings",
    srcs = ["apply-idea-settings.sh"],
    data = [
        ":plugins_tar",
        "@idea-IC//:bin/idea.sh",
        "@idea-IC//:bin/linux/idea64.vmoptions",
    ],
    deps = ["@bazel_tools//tools/bash/runfiles"],
)

test_suite(
    name = "tests",
    tests = [
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment/compiler",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment/build_tools/maven",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/codestyle/java",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/general/auto_import",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/spelling",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/other_settings/checkstyle",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/project_settings/project",
    ],
)

test_suite(
    name = "integration-tests",
    tests = [
        "//src/test/java/com/github/alexandrecarlton/idea/settings/integration",
    ],
)
