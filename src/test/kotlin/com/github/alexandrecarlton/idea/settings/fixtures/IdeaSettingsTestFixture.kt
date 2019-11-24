package com.github.alexandrecarlton.idea.settings.fixtures

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.junit.MockitoJUnit
import java.nio.file.Paths

/**
 * Helper class to allow the test to run with JUnit 4.
 */
@RunWith(JUnit4::class)
open class IdeaSettingsTestFixture : BasePlatformTestCase() {

    @get:Rule
    public val mockitoRule = MockitoJUnit.rule()

    @get:Rule
    public val temporaryFolder = TemporaryFolder(Paths.get("/tmp").toFile())

    @Before
    @Throws(Exception::class)
    fun setUpIdeaSettingsTestFixture() {
        System.setProperty("idea.config.path", temporaryFolder.newFolder("idea", "config").toString())
        System.setProperty("idea.system.path", temporaryFolder.newFolder("idea", "system").toString())

        super.setUp()
    }

    @After
    @Throws(Exception::class)
    fun tearDownIdeaSettingsTestFixture() {
        super.tearDown()
    }
}
