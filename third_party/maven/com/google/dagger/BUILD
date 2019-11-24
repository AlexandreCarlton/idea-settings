java_library(
    name = "dagger",
    exports = [
        "//external:jar/com/google/dagger/dagger",
        "//third_party/maven/javax/inject:javax_inject"
    ],
    licenses = [
        "permissive"
    ],
    visibility = [
        "//visibility:public"
    ]
)



java_library(
    name = "dagger_compiler",
    exported_plugins = [
        ":dagger_compiler_plugin"
    ],
    exports = [
        "//external:jar/com/google/dagger/dagger_compiler",
        "//third_party/maven/com/google/googlejavaformat:google_java_format",
        "//third_party/maven/com/google/guava:failureaccess",
        "//third_party/maven/com/google/guava:guava",
        "//third_party/maven/com/squareup:javapoet",
        "//third_party/maven/javax/annotation:jsr250_api",
        "//third_party/maven/javax/inject:javax_inject",
        "//third_party/maven/net/ltgt/gradle/incap:incap",
        "//third_party/maven/org/checkerframework:checker_compat_qual",
        "//third_party/maven/org/jetbrains/kotlin:kotlin_stdlib",
        "//third_party/maven/org/jetbrains/kotlinx:kotlinx_metadata_jvm",
        ":dagger",
        ":dagger_producers",
        ":dagger_spi"
    ],
    licenses = [
        "permissive"
    ],
    visibility = [
        "//visibility:public"
    ]
)
java_plugin(
    name = "dagger_compiler_plugin",
    deps = [
        "//external:jar/com/google/dagger/dagger_compiler",
        "//third_party/maven/com/google/googlejavaformat:google_java_format",
        "//third_party/maven/com/google/guava:failureaccess",
        "//third_party/maven/com/google/guava:guava",
        "//third_party/maven/com/squareup:javapoet",
        "//third_party/maven/javax/annotation:jsr250_api",
        "//third_party/maven/javax/inject:javax_inject",
        "//third_party/maven/net/ltgt/gradle/incap:incap",
        "//third_party/maven/org/checkerframework:checker_compat_qual",
        "//third_party/maven/org/jetbrains/kotlin:kotlin_stdlib",
        "//third_party/maven/org/jetbrains/kotlinx:kotlinx_metadata_jvm",
        ":dagger",
        ":dagger_producers",
        ":dagger_spi"
    ],
    generates_api = True,
    licenses = [
        "permissive"
    ],
    processor_class = "dagger.internal.codegen.ComponentProcessor",
    visibility = [
        "//visibility:public"
    ]
)




java_library(
    name = "dagger_producers",
    exports = [
        "//external:jar/com/google/dagger/dagger_producers",
        "//third_party/maven/com/google/guava:failureaccess",
        "//third_party/maven/com/google/guava:guava",
        "//third_party/maven/javax/inject:javax_inject",
        "//third_party/maven/org/checkerframework:checker_compat_qual",
        ":dagger"
    ],
    licenses = [
        "permissive"
    ],
    visibility = [
        "//third_party/maven:__subpackages__"
    ]
)



java_library(
    name = "dagger_spi",
    exports = [
        "//external:jar/com/google/dagger/dagger_spi",
        "//third_party/maven/com/google/guava:failureaccess",
        "//third_party/maven/com/google/guava:guava",
        "//third_party/maven/com/squareup:javapoet",
        "//third_party/maven/javax/inject:javax_inject",
        ":dagger",
        ":dagger_producers"
    ],
    licenses = [
        "permissive"
    ],
    visibility = [
        "//third_party/maven:__subpackages__"
    ]
)


