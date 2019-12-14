package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.application

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.configurations.application.ApplicationConfigurationConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.ApplicationConfigurationSettings
import com.intellij.execution.RunManager
import com.intellij.execution.application.ApplicationConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import java.nio.file.Paths

class ApplicationConfigurationSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<ApplicationConfigurationSettings>
    private lateinit var runManager: RunManager

    @Before
    public override fun setUp() {
        runManager = RunManager.getInstance(project)
        settingsApplier = ApplicationConfigurationSettingsApplier(project, runManager)
    }

    @Test
    fun basicApplicationApplied() {
        settingsApplier.apply(ApplicationConfigurationSettings(
            name = "Basic Application",
            configuration = ApplicationConfigurationConfigurationSettings(
                mainClass = "com.Application",
                useClassPathOfModule = "app")))

        val configuration = runManager.findConfigurationByName("Basic Application")!!.configuration as ApplicationConfiguration
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

        val configuration = runManager.findConfigurationByName("Application with VM Options")!!.configuration as ApplicationConfiguration
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

        val configuration = runManager.findConfigurationByName("Application with Program Arguments")!!.configuration as ApplicationConfiguration
        assertThat(configuration.programParameters).isEqualTo("foo bar")
    }

    @Test
    fun workingDirectoryApplied() {
        settingsApplier.apply(ApplicationConfigurationSettings(
            name = "Application with Working Directory",
            configuration = ApplicationConfigurationConfigurationSettings(
                mainClass = "com.Application",
                useClassPathOfModule = "app",
                workingDirectory = Paths.get("/root"))))

        val configuration = runManager.findConfigurationByName("Application with Working Directory")!!.configuration as ApplicationConfiguration
        assertThat(configuration.workingDirectory).isEqualTo("/root")
    }
}
