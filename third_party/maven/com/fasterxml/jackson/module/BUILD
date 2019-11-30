# Manually added the 'load' step.
load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_import")
kt_jvm_import(
    name = "jackson_module_kotlin",
    exports = [
        "//third_party/maven/com/fasterxml/jackson/core:jackson_annotations",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_databind",
        "//third_party/maven/org/jetbrains/kotlin:kotlin_reflect"
    ],
    jars = [
        "//external:jar/com/fasterxml/jackson/module/jackson_module_kotlin"
    ],
    visibility = [
        "//visibility:public"
    ]
)


