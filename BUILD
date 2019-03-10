alias(
    name = "idea-settings",
    actual = "//src/main/java/com/github/alexandrecarlton/idea/settings/starter:idea-settings",
)

test_suite(
    name = "tests",
    tests = [
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/build_execution_deployment/compiler",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/codestyle/java",
        "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/editor/general/auto_import",
        # Disabled as we are getting the following error ONLY in CI:
        #   ERROR: java.io.FileNotFoundException:
        #   /root/.cache/bazel/_bazel_root/f85b6fb5740e6e8c7efea142eec4b6e8/sandbox/processwrapper-sandbox/8/execroot/__main__/_tmp/af2f2738550a6e09f3618e4dac32efbd
        #   /junit3062036461441905122/idea-system/index/stubs/properties.index/properties.index.storage.keystream (No such file or directory)
        # "//src/test/java/com/github/alexandrecarlton/idea/settings/applier/impl/other_settings/checkstyle",
    ],
)
