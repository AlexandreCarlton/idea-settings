package com.github.alexandrecarlton.idea.settings.integration

import org.junit.BeforeClass
import org.junit.Test
import java.io.IOException
import java.nio.file.Path
import kotlin.jvm.Throws

/**
 * An integration test primarily designed to test module addition and modification.
 */
class AutoIntegrationTest : AbstractIntegrationTest() {

    companion object {
        @JvmStatic
        @BeforeClass
        fun setUpClass() {
            setUpClass("auto", """
                Project Settings:
                  Modules:
                    - Name: auto-parent
                      Sources:
                        - Content Root: .
                          Excluded:
                            - README.md
                    - Name: auto-service
                      Sources:
                        - Content Root: service/processor
                          Sources:
                            - Root: src/main/java
                          Tests:
                            - Root: src/test/java
                          Resources:
                            - Root: src/main/resources
                          Test Resources:
                            - Root: src/test/resources
                            """.trimIndent())
            runIdeaSettings()
        }
    }

    @Test
    fun testExcludeFileOnExistingModule() {
        assertThatXml("auto-parent.iml")
            .hasXPath("//content[@url='file://\$MODULE_DIR$']/excludeFolder[@url='file://\$MODULE_DIR$/README.md']")
    }

    @Test
    fun sourceInCreatedModule() {
        assertThatXml("service/processor/auto-service.iml")
            .hasXPath("//content[@url='file://\$MODULE_DIR$']/sourceFolder[@url='file://\$MODULE_DIR$/src/main/java'][@isTestSource='false']")
    }

    @Test
    fun testSourceInCreatedModule() {
        assertThatXml("service/processor/auto-service.iml")
            .hasXPath("//content[@url='file://\$MODULE_DIR$']/sourceFolder[@url='file://\$MODULE_DIR$/src/test/java'][@isTestSource='true']")
    }

    @Test
    fun resourceInCreatedModule() {
        assertThatXml("service/processor/auto-service.iml")
                .hasXPath("//content[@url='file://\$MODULE_DIR$']/sourceFolder[@url='file://\$MODULE_DIR$/src/main/resources'][@type='java-resource']")
    }

    @Test
    fun testResourceInCreatedModule() {
        assertThatXml("service/processor/auto-service.iml")
                .hasXPath("//content[@url='file://\$MODULE_DIR$']/sourceFolder[@url='file://\$MODULE_DIR$/src/test/resources'][@type='java-test-resource']")
    }
}
