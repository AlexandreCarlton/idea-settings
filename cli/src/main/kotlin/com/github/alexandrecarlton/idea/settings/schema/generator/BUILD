load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_binary")

kt_jvm_binary(
    name = "generator",
    srcs = ["IdeaSettingsSchemaGenerator.kt"],
    main_class = "com.github.alexandrecarlton.idea.settings.schema.generator.IdeaSettingsSchemaGenerator",
    visibility = ["//visibility:public"],
    deps = [
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_module_jackson_module_kotlin",
        "@maven//:com_github_victools_jsonschema_generator",
        "@maven//:com_github_victools_jsonschema_module_jackson",
    ],
)
