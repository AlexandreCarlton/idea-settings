load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "kotlin",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/blank_lines",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/code_generation",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/imports",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/tabs_and_indents",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/editor/codestyle/kotlin/wrapping_and_braces",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:plugins/Kotlin/lib/kotlin-plugin",
        "@maven//:javax_inject_javax_inject",
    ],
)
