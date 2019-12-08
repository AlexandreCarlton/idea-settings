load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "spring_boot",
    srcs = glob(["*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/applier/api",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations",
        "//src/main/kotlin/com/github/alexandrecarlton/idea/settings/layout/configurations/common/before_launch",
        "@maven//:javax_inject_javax_inject",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/java/lib/java-api",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@idea-IC//:plugins/maven/lib/maven",
        "@idea-IU//:plugins/SpringBoot/lib/spring-boot",
        "@idea-IU//:plugins/SpringBoot/lib/spring-boot-run",
    ],
)
