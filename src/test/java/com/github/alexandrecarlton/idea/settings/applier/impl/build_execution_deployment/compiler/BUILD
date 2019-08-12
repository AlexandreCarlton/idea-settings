test_suite(
    name = "compiler",
    tests = [
        ":compiler_settings_applier_test",
    ],
)

java_test(
    name = "compiler_settings_applier_test",
    srcs = ["CompilerSettingsApplierTest.java"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.build_execution_deployment.compiler.CompilerSettingsApplierTest",
    runtime_deps = ["@idea-IC//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment/compiler",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/build_execution_deployment/compiler",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:plugins/java/lib/java-api",
    ],
)
