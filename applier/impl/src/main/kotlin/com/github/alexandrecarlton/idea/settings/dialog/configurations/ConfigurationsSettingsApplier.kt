package com.github.alexandrecarlton.idea.settings.dialog.configurations

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.subcomponent.ConfigurationSubcomponent
import com.intellij.execution.RunManager
import com.intellij.openapi.project.Project
import java.util.ArrayList
import javax.inject.Inject

class ConfigurationsSettingsApplier @Inject
constructor(
    private val project: Project,
    private val runManager: RunManager,
    private val configurationSubcomponentBuilder: ConfigurationSubcomponent.Builder,

    private val applicationConfigurationSettingsApplier: SettingsApplier<ApplicationConfigurationSettings>,
    private val dockerComposeConfigurationSettingsApplier: SettingsApplier<DockerComposeConfigurationSettings>,
    private val dockerImageConfigurationSettingsApplier: SettingsApplier<DockerImageConfigurationSettings>,
    private val npmConfigurationSettingsApplier: SettingsApplier<NpmConfigurationSettings>,
    private val remoteConfigurationApplier: SettingsApplier<RemoteSettings>,
    private val springBootConfigurationApplier: SettingsApplier<SpringBootSettings>
) : SettingsApplier<ConfigurationSettings> {

    override fun apply(settings: ConfigurationSettings) {
        when (settings) {
            is ApplicationConfigurationSettings -> applicationConfigurationSettingsApplier.apply(settings)
            is DockerComposeConfigurationSettings -> dockerComposeConfigurationSettingsApplier.apply(settings)
            is DockerImageConfigurationSettings -> dockerImageConfigurationSettingsApplier.apply(settings)
            is RemoteSettings -> remoteConfigurationApplier.apply(settings)
            is NpmConfigurationSettings -> npmConfigurationSettingsApplier.apply(settings)
            is SpringBootSettings -> springBootConfigurationApplier.apply(settings)
        }

        val runnerAndConfigurationSettings = runManager.findConfigurationByName(settings.name) ?: return
        settings.beforeLaunch?.let { _ -> runnerAndConfigurationSettings.configuration.beforeRunTasks = ArrayList() }
        val configurationSubcomponent = configurationSubcomponentBuilder
            .configuration(settings.name)
            .build()
        (settings.beforeLaunch ?: emptyList())
            .forEach { configurationSubcomponent.beforeLaunchConfigurationSettingsApplier().apply(it) }

        runnerAndConfigurationSettings.configuration
            .beforeRunTasks
            .forEach { task -> task.setEnabled(true) }

        // To share through VCS we need to re-add the configuration.
        settings.storeAsProjectFile?.let {
            if (it) {
                // TODO: account for settings.storeConfigurationFileIn
                // If we store as a project file, storing it in `.idea/runConfigurations` is the default option.
                runnerAndConfigurationSettings.storeInDotIdeaFolder()
            } else {
                runnerAndConfigurationSettings.storeInLocalWorkspace()
            }
        }
        runManager.addConfiguration(runnerAndConfigurationSettings)
    }
}
