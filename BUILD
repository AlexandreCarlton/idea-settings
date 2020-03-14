package(default_visibility = ["//visibility:public"])

load(
    "@intellij_with_bazel//build_defs:build_defs.bzl",
    "intellij_plugin",
    "intellij_plugin_library",
)
load("@rules_pkg//:pkg.bzl", "pkg_tar")

intellij_plugin(
    name = "idea-settings",
    plugin_xml = "plugin/src/main/resources/META-INF/plugin.xml",
    deps = [":plugin_library"],
)

intellij_plugin_library(
    name = "plugin_library",
    deps = ["//plugin/src/main/kotlin/com/github/alexandrecarlton/idea/settings/plugin"],
)

pkg_tar(
    name = "plugins",
    srcs = [":idea-settings"],
    files = {
        "@CheckStyle-IDEA//:lib/checkstyle-idea.jar": "CheckStyle-IDEA/lib/checkstyle-idea.jar",
        "@Save-Actions//jar:file": "save-actions.jar",
        "@WebStorm//:plugins/fileWatcher/lib/fileWatcher.jar": "fileWatcher/lib/fileWatcher.jar",
        "@WebStorm//:plugins/fileWatcher/lib/resources_en.jar": "fileWatcher/lib/resources_en.jar",
    },
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
        ":idea.sh",
        ":idea64.vmoptions",
        ":plugins_tar",
    ],
    deps = ["@bazel_tools//tools/bash/runfiles"],
)

alias(
    name = "idea.sh",
    actual = select({
        "intellij-idea-community": "@idea-IC//:bin/idea.sh",
        "intellij-idea-ultimate": "@idea-IU//:bin/idea.sh",
    }),
)

alias(
    name = "idea64.vmoptions",
    actual = select({
        "intellij-idea-community": "@idea-IC//:bin/linux/idea64.vmoptions",
        "intellij-idea-ultimate": "@idea-IU//:bin/linux/idea64.vmoptions",
    }),
)

config_setting(
    name = "intellij-idea-community",
    values = {"define": "product=intellij-idea-community"},
)

config_setting(
    name = "intellij-idea-ultimate",
    values = {"define": "product=intellij-idea-ultimate"},
)

test_suite(
    name = "tests",
    tests = [
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment/build_tools/maven",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/build_execution_deployment/compiler",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/application",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/docker",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/npm",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/remote",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/shell_script",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/spring_boot",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/java/arrangement",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/java/blank_lines",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/java/imports",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/java/javadoc",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/java/wrapping_and_braces",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/javascript",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/general/auto_import",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/spelling",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks/javascript",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks/javascript/code_quality_tools/eslint",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks/nodejs_and_npm",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/languages_frameworks/sql_dialects",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/other_settings/checkstyle",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/other_settings/save_actions",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/project_settings/project",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/dialog/tools/file_watchers",
    ],
)

test_suite(
    name = "integration-tests",
    tests = [
        "//plugin/src/test/kotlin/com/github/alexandrecarlton/idea/settings/integration",
    ],
)

# TODO: Use @com_google_dagger//:dagger_with_compiler once it is discovered
# how to use this with kotlin.
java_library(
    name = "dagger_with_compiler",
    exported_plugins = [":dagger_with_compiler_plugin"],
    exports = [
        "@maven//:com_google_dagger_dagger",
        "@maven//:com_google_dagger_dagger_compiler",
    ],
)

java_plugin(
    name = "dagger_with_compiler_plugin",
    generates_api = True,
    processor_class = "dagger.internal.codegen.ComponentProcessor",
    deps = [
        "@maven//:com_google_dagger_dagger",
        "@maven//:com_google_dagger_dagger_compiler",
    ],
)
