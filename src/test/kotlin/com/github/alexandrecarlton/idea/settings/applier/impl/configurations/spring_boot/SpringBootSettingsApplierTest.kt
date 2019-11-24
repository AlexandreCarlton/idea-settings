package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.spring_boot

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.fixtures.IdeaSettingsTestFixture
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.ImmutableOverrideParameter
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.ImmutableSpringBootConfigurationEnvironmentSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.ImmutableSpringBootConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.ImmutableSpringBootConfigurationSpringBootSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.ImmutableSpringBootSettings
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
        settingsApplier.apply(ImmutableSpringBootSettings.builder()
                .name("Spring Boot Basic")
                .configuration(ImmutableSpringBootConfigurationSettings.builder()
                        .mainClass("com.Application")
                        .build())
                .build())

        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Spring Boot Basic")
        assertThat(runnerAndConfigurationSettings).isNotNull()

        val configuration = runnerAndConfigurationSettings!!.configuration as SpringBootApplicationRunConfiguration
        assertThat(configuration.springBootMainClass).isEqualTo("com.Application")
    }

    @Test
    fun dependenciesWithProvidedScopeApplied() {
        settingsApplier.apply(ImmutableSpringBootSettings.builder()
                .name("Spring Boot With Provided")
                .configuration(ImmutableSpringBootConfigurationSettings.builder()
                        .mainClass("com.Application")
                        .environment(ImmutableSpringBootConfigurationEnvironmentSettings.builder()
                                .includeDependenciesWithProvidedScope(false)
                                .build())
                        .build())
                .build())

        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Spring Boot With Provided")!!
        val configuration = runnerAndConfigurationSettings.configuration as SpringBootApplicationRunConfiguration
        assertThat(configuration).isNotNull()
        assertThat(configuration.isIncludeProvidedScope).isFalse()
    }

    // TODO: test useClassPathOfModule - will likely require module creation.

    @Test
    fun vmOptionsApplied() {
        settingsApplier.apply(ImmutableSpringBootSettings.builder()
                .name("Spring Boot With VM Options")
                .configuration(ImmutableSpringBootConfigurationSettings.builder()
                        .mainClass("com.Application")
                        .environment(ImmutableSpringBootConfigurationEnvironmentSettings.builder()
                                .vmOptions("-Xmx123m")
                                .build())
                        .build())
                .build())

        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Spring Boot With VM Options")!!
        val configuration = runnerAndConfigurationSettings.configuration as SpringBootApplicationRunConfiguration
        assertThat(configuration).isNotNull()
        assertThat(configuration.vmParameters).isEqualTo("-Xmx123m")
    }

    @Test
    fun overrideParametersApplied() {
        settingsApplier.apply(ImmutableSpringBootSettings.builder()
                .name("Spring Boot With Override")
                .configuration(ImmutableSpringBootConfigurationSettings.builder()
                        .mainClass("com.Application")
                        .springBoot(ImmutableSpringBootConfigurationSpringBootSettings.builder()
                                .addOverrideParameters(ImmutableOverrideParameter.builder()
                                        .name("Key")
                                        .value("Value")
                                        .build())
                                .build())
                        .build())
                .build())

        val runnerAndConfigurationSettings = runManager.findConfigurationByName("Spring Boot With Override")!!
        val configuration = runnerAndConfigurationSettings.configuration as SpringBootApplicationRunConfiguration
        assertThat(configuration).isNotNull()
        assertThat(configuration.additionalParameters).containsExactly(SpringBootAdditionalParameter(true, "Key", "Value"))
    }
}
