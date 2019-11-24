load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_test")

test_suite(
    name = "docker",
    tests = [
        ":docker_compose_configuration_settings_applier_test",
        ":docker_image_configuration_settings_applier_test",
    ],
)

kt_jvm_test(
    name = "docker_compose_configuration_settings_applier_test",
    srcs = ["DockerComposeConfigurationSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.configurations.docker.DockerComposeConfigurationSettingsApplierTest",
    runtime_deps = ["@idea-IU//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/configurations/docker",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/configurations",
        "//src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IU//:plugins/Docker/lib/Docker-agent-api-rt",
        "@idea-IU//:plugins/Docker/lib/Docker-core",
    ],
)

kt_jvm_test(
    name = "docker_image_configuration_settings_applier_test",
    srcs = ["DockerImageConfigurationSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.applier.impl.configurations.docker.DockerImageConfigurationSettingsApplierTest",
    runtime_deps = ["@idea-IU//:test_runtime_deps"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/impl/configurations/docker",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/configurations",
        "//src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//third_party/maven/com/google/guava",
        "//third_party/maven/junit",
        "//third_party/maven/org/assertj:assertj_core",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IU//:plugins/Docker/lib/Docker-agent-api-rt",
        "@idea-IU//:plugins/Docker/lib/Docker-core",
    ],
)
