java_library(
    name = "before_launch",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/applier/api",
        # TODO: Rethink dependency on dagger
        "//src/main/java/com/github/alexandrecarlton/idea/settings/dagger/common",
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/configurations/common/before_launch",
        "//third_party/maven/javax/inject:javax_inject",
        "@idea-IC//:lib/extensions",
        "@idea-IC//:lib/platform-api",
        "@idea-IC//:lib/platform-impl",
        "@idea-IC//:lib/util",
        "@idea-IC//:plugins/java/lib/java-impl",
        "@idea-IC//:plugins/maven/lib/maven",
        "@idea-IC//:plugins/sh/lib/sh",
        "@idea-IU//:plugins/Docker/lib/Docker-core",
        "@idea-IU//:plugins/SpringBoot/lib/spring-boot-run",
        "@idea-IU//:plugins/SpringBoot/lib/spring-boot",
    ],
)
