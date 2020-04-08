load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "intellij",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//:dagger_with_compiler",
        "//dagger/src/main/kotlin/com/github/alexandrecarlton/idea/settings/common",
        "@CheckStyle-IDEA//:lib/checkstyle-idea",
        "@Save-Actions//jar",
        "@SonarLint//:lib/sonarlint-intellij",
        "@WebStorm//:plugins/fileWatcher/lib/fileWatcher",
        # Without the annotations library, we get warnings like:
        # warning: unknown enum constant Nls$Capitalization.Sentence
        "@idea-IC//:lib/annotations",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/json",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/spellchecker",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/java/lib/java-api",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@idea-IC//:plugins/Kotlin/lib/kotlin-plugin",
        "@idea-IC//:plugins/markdown/lib/markdown",
        "@idea-IC//:plugins/maven/lib/maven",
        "@idea-IC//:plugins/sh/lib/sh",
        "@idea-IU//:plugins/CSS/lib/css-openapi",
        "@idea-IU//:plugins/DatabaseTools/lib/database-impl",
        "@idea-IU//:plugins/Docker/lib/Docker-core",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/JavaScriptLanguage",
        "@idea-IU//:plugins/JavaScriptLanguage/lib/javascript-openapi",
        "@idea-IU//:plugins/less/lib/less",
        "@idea-IU//:plugins/SpringBoot/lib/spring-boot",
        "@idea-IU//:plugins/SpringBoot/lib/spring-boot-run",
    ],
)
