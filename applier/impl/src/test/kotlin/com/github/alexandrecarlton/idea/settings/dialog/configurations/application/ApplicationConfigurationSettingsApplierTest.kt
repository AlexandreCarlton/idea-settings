package com.github.alexandrecarlton.idea.settings.dialog.configurations.application

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.ApplicationConfigurationSettings
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.intellij.execution.application.ApplicationConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.io.File

class ApplicationConfigurationSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<ApplicationConfigurationSettings>

    @Before
    public override fun setUp() {
        settingsApplier = ApplicationConfigurationSettingsApplier(project, platform.runManager)
    }

    @Test
    fun basicApplicationApplied() {
        settingsApplier.apply(ApplicationConfigurationSettings(
            name = "Basic Application",
            configuration = ApplicationConfigurationConfigurationSettings(
                mainClass = "com.Application",
                useClassPathOfModule = "app")))

        val configuration = platform.runManager.findConfigurationByName("Basic Application")!!.configuration as ApplicationConfiguration
        assertThat(configuration.mainClassName).isEqualTo("com.Application")
        assertThat(configuration.configurationModule.moduleName).isEqualTo("app")
    }

    @Test
    fun vmOptionsApplied() {
        settingsApplier.apply(ApplicationConfigurationSettings(
            name = "Application with VM Options",
            configuration = ApplicationConfigurationConfigurationSettings(
                mainClass = "com.Application",
                useClassPathOfModule = "app",
                vmOptions = "-Xmx3g")))

        val configuration = platform.runManager.findConfigurationByName("Application with VM Options")!!.configuration as ApplicationConfiguration
        assertThat(configuration.vmParameters).isEqualTo("-Xmx3g")
    }

    @Test
    fun programArgumentsApplied() {
        settingsApplier.apply(ApplicationConfigurationSettings(
            name = "Application with Program Arguments",
            configuration = ApplicationConfigurationConfigurationSettings(
                mainClass = "com.Application",
                useClassPathOfModule = "app",
                programArguments = "foo bar")))

        val configuration = platform.runManager.findConfigurationByName("Application with Program Arguments")!!.configuration as ApplicationConfiguration
        assertThat(configuration.programParameters).isEqualTo("foo bar")
    }

    @Test
    fun workingDirectoryApplied() {
        settingsApplier.apply(ApplicationConfigurationSettings(
            name = "Application with Working Directory",
            configuration = ApplicationConfigurationConfigurationSettings(
                mainClass = "com.Application",
                useClassPathOfModule = "app",
                workingDirectory = File("/root"))))

        val configuration = platform.runManager.findConfigurationByName("Application with Working Directory")!!.configuration as ApplicationConfiguration
        assertThat(configuration.workingDirectory).isEqualTo("/root")
    }
}
