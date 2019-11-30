package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.spring_boot

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootConfigurationEnvironmentSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootConfigurationSpringBootSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot.SpringBootSettings
import com.intellij.execution.RunManager
import com.intellij.openapi.project.Project
import com.intellij.spring.boot.run.SpringBootAdditionalParameter
import com.intellij.spring.boot.run.SpringBootApplicationConfigurationType
import com.intellij.spring.boot.run.SpringBootApplicationRunConfiguration
import javax.inject.Inject

class SpringBootSettingsApplier @Inject
constructor(private val project: Project, private val runManager: RunManager) : SettingsApplier<SpringBootSettings> {

    override fun apply(settings: SpringBootSettings) {
        val configuration = SpringBootApplicationRunConfiguration(
            project,
            SpringBootApplicationConfigurationType().defaultConfigurationFactory,
            settings.name())
        configuration.setMainClassName(settings.configuration().mainClass())
        settings.configuration().environment().ifPresent { env -> setSpringBootEnvironment(configuration, env) }
        settings.configuration().springBoot().ifPresent { config -> setSpringBootConfiguration(configuration, config) }
        val runnerAndConfigurationSettings = runManager.createConfiguration(configuration, SpringBootApplicationConfigurationType().defaultConfigurationFactory)
        runManager.addConfiguration(runnerAndConfigurationSettings)
    }

    private fun setSpringBootEnvironment(configuration: SpringBootApplicationRunConfiguration,
                                         settings: SpringBootConfigurationEnvironmentSettings) {
        settings
            .includeDependenciesWithProvidedScope()
            .ifPresent { configuration.isIncludeProvidedScope = it }
        settings
            .useClassPathOfModule()
            .ifPresent { configuration.setModuleName(it) }
        settings
            .vmOptions()
            .ifPresent { configuration.vmParameters = it }
    }

    private fun setSpringBootConfiguration(configuration: SpringBootApplicationRunConfiguration,
                                           settings: SpringBootConfigurationSpringBootSettings) {
        configuration.additionalParameters = settings
            .overrideParameters()
            .map { parameter -> SpringBootAdditionalParameter(true, parameter.name(), parameter.value()) }
    }
}
