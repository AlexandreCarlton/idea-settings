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
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.configurations.docker.DockerComposeConfigurationSettingsApplierTest",
    runtime_deps = ["@idea-IU//:Docker_runtime"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/docker",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/common/environment",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/docker",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IU//:plugins/Docker/lib/Docker-agent-api-rt",
        "@idea-IU//:plugins/Docker/lib/Docker-core",
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)

kt_jvm_test(
    name = "docker_image_configuration_settings_applier_test",
    srcs = ["DockerImageConfigurationSettingsApplierTest.kt"],
    test_class = "com.github.alexandrecarlton.idea.settings.dialog.configurations.docker.DockerImageConfigurationSettingsApplierTest",
    runtime_deps = ["@idea-IU//:Docker_runtime"],
    deps = [
        "//applier/api/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog",
        "//applier/impl/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/docker",
        "//applier/impl/src/test/kotlin/com/github/alexandrecarlton/idea/settings/fixtures",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/common/environment",
        "//layout/src/main/kotlin/com/github/alexandrecarlton/idea/settings/dialog/configurations/docker",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IU//:plugins/Docker/lib/Docker-agent-api-rt",
        "@idea-IU//:plugins/Docker/lib/Docker-core",
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
    ],
)
