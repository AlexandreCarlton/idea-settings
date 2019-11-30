package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.spring_boot

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.OverrideParameter
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootConfigurationEnvironmentSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootConfigurationSpringBootSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootSettings
import com.intellij.execution.RunManager
import com.intellij.spring.boot.run.SpringBootAdditionalParameter
import com.intellij.spring.boot.run.SpringBootApplicationRunConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class SpringBootSettingsApplierTest : IdeaSettingsTestFixture() {

    private lateinit var settingsApplier: SettingsApplier<SpringBootSettings>
    private lateinit var runManager: RunManager

    @Before
    public override fun setUp() {
        runManager = RunManager.getInstance(project)
        settingsApplier = SpringBootSettingsApplier(project, runManager)
    }

    @Test
    fun basicSpringConfiguration() {
        settingsApplier.apply(SpringBootSettings(
                name = "Spring Boot Basic",
                configuration = SpringBootConfigurationSettings(
                    mainClass = "com.Application")))

        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Spring Boot Basic")
        assertThat(runnerAndConfigurationSettings).isNotNull()

        val configuration = runnerAndConfigurationSettings!!.configuration as SpringBootApplicationRunConfiguration
        assertThat(configuration.springBootMainClass).isEqualTo("com.Application")
    }

    @Test
    fun dependenciesWithProvidedScopeApplied() {
        settingsApplier.apply(SpringBootSettings(
                name = "Spring Boot With Provided",
                configuration = SpringBootConfigurationSettings(
                    mainClass = "com.Application",
                    environment = SpringBootConfigurationEnvironmentSettings(
                        includeDependenciesWithProvidedScope = false))))

        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Spring Boot With Provided")!!
        val configuration = runnerAndConfigurationSettings.configuration as SpringBootApplicationRunConfiguration
        assertThat(configuration).isNotNull()
        assertThat(configuration.isIncludeProvidedScope).isFalse()
    }

    // TODO: test useClassPathOfModule - will likely require module creation.

    @Test
    fun vmOptionsApplied() {
        settingsApplier.apply(SpringBootSettings(
                name = "Spring Boot With VM Options",
                configuration = SpringBootConfigurationSettings(
                    mainClass = "com.Application",
                    environment = SpringBootConfigurationEnvironmentSettings(
                        vmOptions = "-Xmx123m"))))

        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Spring Boot With VM Options")!!
        val configuration = runnerAndConfigurationSettings.configuration as SpringBootApplicationRunConfiguration
        assertThat(configuration).isNotNull()
        assertThat(configuration.vmParameters).isEqualTo("-Xmx123m")
    }

    @Test
    fun overrideParametersApplied() {
        settingsApplier.apply(SpringBootSettings(
                name = "Spring Boot With Override",
                configuration = SpringBootConfigurationSettings(
                    mainClass = "com.Application",
                    springBoot = SpringBootConfigurationSpringBootSettings(
                        overrideParameters = listOf(OverrideParameter(name = "Key", value = "Value"))))))

        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Spring Boot With Override")!!
        val configuration = runnerAndConfigurationSettings.configuration as SpringBootApplicationRunConfiguration
        assertThat(configuration).isNotNull()
        assertThat(configuration.additionalParameters).containsExactly(SpringBootAdditionalParameter(true, "Key", "Value"))
    }
}
