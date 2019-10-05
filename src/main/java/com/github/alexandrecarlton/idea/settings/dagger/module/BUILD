java_library(
    name = "module",
    srcs = glob(["*.java"]),
    plugins = ["//third_party/maven/com/google/dagger:dagger_compiler_plugin"],
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/project_settings/modules",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/project_settings/modules",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_databind",
        "//third_party/maven/com/google/dagger",
        "@idea-IC//:lib/platform-api",
    ],
)
