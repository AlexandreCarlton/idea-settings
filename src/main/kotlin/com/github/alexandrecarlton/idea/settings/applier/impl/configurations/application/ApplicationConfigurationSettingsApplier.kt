package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.application

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.configurations.ApplicationConfigurationSettings
import com.intellij.execution.RunManager
import com.intellij.execution.application.ApplicationConfiguration
import com.intellij.execution.application.ApplicationConfigurationType
import com.intellij.openapi.project.Project
import javax.inject.Inject

class ApplicationConfigurationSettingsApplier
@Inject constructor(
    private val project: Project,
    private val runManager: RunManager) : SettingsApplier<ApplicationConfigurationSettings> {

    override fun apply(settings: ApplicationConfigurationSettings) {
        val applicationConfiguration = ApplicationConfiguration(settings.name, project)

        applicationConfiguration.mainClassName = settings.configuration.mainClass
        applicationConfiguration.setModuleName(settings.configuration.useClassPathOfModule)

        settings.configuration.vmOptions?.let { applicationConfiguration.vmParameters = it }
        settings.configuration.programArguments?.let { applicationConfiguration.programParameters = it }
        settings.configuration.workingDirectory?.let { applicationConfiguration.workingDirectory = it.absolutePath }

        val runnerAndConfigurationSettings = runManager.createConfiguration(
            applicationConfiguration,
            ApplicationConfigurationType.getInstance().configurationFactories[0])
        runManager.addConfiguration(runnerAndConfigurationSettings)
    }
}
