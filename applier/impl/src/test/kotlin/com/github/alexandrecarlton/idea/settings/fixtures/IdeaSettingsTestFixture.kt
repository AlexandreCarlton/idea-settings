package com.github.alexandrecarlton.idea.settings.fixtures

import com.github.alexandrecarlton.idea.settings.intellij.DaggerIntellijPlatformComponent
import com.github.alexandrecarlton.idea.settings.intellij.IntellijPlatformComponent
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.nio.file.Paths

/**
 * Helper class to allow the test to run with JUnit 4.
 */
@RunWith(JUnit4::class)
open class IdeaSettingsTestFixture : BasePlatformTestCase() {

    @get:Rule
    val temporaryFolder = TemporaryFolder(Paths.get("/tmp").toFile())

    // TODO: Try to make this delegateable so we can access the members directly instead of through this variable.
    protected lateinit var platform: IntellijPlatformComponent

    // We deliberately do not name these @Before/@After methods `setUp` and `tearDown`
    // so we do not have to call super.setUp() in our child setUp methods.
    // JUnit will ensure this method is called before our child @Before method.
    @Before
    @Throws(Exception::class)
    fun setUpIdeaSettingsTestFixture() {
        System.setProperty("idea.config.path", temporaryFolder.newFolder("idea", "config").toString())
        System.setProperty("idea.system.path", temporaryFolder.newFolder("idea", "system").toString())

        // Sets up our project
        super.setUp()

        platform = DaggerIntellijPlatformComponent.factory().create(project)
    }

    @After
    @Throws(Exception::class)
    fun tearDownIdeaSettingsTestFixture() {
        super.tearDown()
    }
}
