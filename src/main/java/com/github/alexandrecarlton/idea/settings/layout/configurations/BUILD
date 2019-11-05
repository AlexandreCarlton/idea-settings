java_library(
    name = "configurations",
    # Having ConfigurationSettings be the parent of *Settings.java
    # but also reference them in JsonSubType annotations creates a circular dependency.
    srcs = glob([
        "*.java",
        "docker/*.java",
        "spring_boot/*.java",
        "remote/*.java",
    ]),
    plugins = ["//third_party/maven/org/immutables:value_plugin"],
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/github/alexandrecarlton/idea/settings/layout/configurations/common/before_launch",
        "//third_party/maven/com/fasterxml/jackson/core:jackson_databind",
        "//third_party/maven/org/immutables:value",
    ],
)
