package com.github.alexandrecarlton.idea.settings.integration

import org.assertj.core.api.Assertions
import org.xmlunit.assertj.XmlAssert
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import build.bazel.tests.integration.WorkspaceDriver
import kotlin.jvm.Throws

/**
 * An base for integration tests that load up an entire project first, and then verify the output in
 * individual tests.
 * The individual tests share a (read-only) state as importing a real project for every test is both memory-
 * and time-intensive.
 */
abstract class AbstractIntegrationTest {

    companion object {

        internal val driver = WorkspaceDriver()
        internal lateinit var path: Path

        fun setUpClass(project: String, vararg ideaSettings: String) {
            WorkspaceDriver.setUpClass()
            driver.setUp()

            driver.copyFromRunfiles("idea_settings/apply-idea-settings.sh", "apply-idea-settings.sh")
            driver.copyFromRunfiles("idea_settings/plugins.tar", "plugins.tar")
            driver.copyFromRunfiles("idea-IC/bin/idea.sh", "idea-IC/bin/idea.sh")
            driver.copyFromRunfiles("idea-IC/bin/linux/idea64.vmoptions",
                "idea-IC/bin/linux/idea64.vmoptions")
            driver.copyDirectoryFromRunfiles(project, "")

            driver.scratchFile("BUILD",
                "sh_binary(",
                "    name = \"apply-idea-settings\",",
                "    srcs = [\"apply-idea-settings.sh\"],",
                "    data = [",
                "        \"plugins.tar\",",
                "        \"idea-IC/bin/idea.sh\",",
                "        \"idea-IC/bin/linux/idea64.vmoptions\",",
                "    ],",
                "    deps = [\"@bazel_tools//tools/bash/runfiles\"],",
                ")")
            driver.scratchFile("$project/.IDEA-settings.yml", *ideaSettings)
            path = driver.currentWorkspace().resolve(project)
        }

        fun runIdeaSettings() {
            driver.bazel("run", "//:apply-idea-settings", path.toString()).mustRunSuccessfully()
        }
    }


    internal fun assertThatXml(file: String?): XmlAssert {
        val xml: Path = path.resolve(file)
        Assertions.assertThat(xml).exists()
        val xmlContent: String = xml.toFile().readText()
        System.out.println("Content of $xml is:")
        System.out.println(xmlContent)
        return XmlAssert.assertThat(xmlContent)
    }
}
