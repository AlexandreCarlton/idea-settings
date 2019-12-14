package com.github.alexandrecarlton.idea.settings.applier.impl.configurations

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dagger.configuration.ConfigurationSubcomponent
import com.github.alexandrecarlton.idea.settings.layout.configurations.ApplicationConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.DockerComposeConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.DockerImageConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.RemoteSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.ShellScriptConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.SpringBootSettings
import com.intellij.execution.RunManager
import java.util.ArrayList
import javax.inject.Inject

class ConfigurationsSettingsApplier @Inject
// TODO: Could we maybe inject the appliers into a map, from class -> applier?
// We lose the 'when' compiler failure though :/
constructor(private val runManager: RunManager,
            private val configurationSubcomponentBuilder: ConfigurationSubcomponent.Builder,
            private val applicationConfigurationSettingsApplier: SettingsApplier<ApplicationConfigurationSettings>,
            private val dockerComposeConfigurationSettingsApplier: SettingsApplier<DockerComposeConfigurationSettings>,
            private val dockerImageConfigurationSettingsApplier: SettingsApplier<DockerImageConfigurationSettings>,
            private val remoteConfigurationApplier: SettingsApplier<RemoteSettings>,
            private val shellScriptConfigurationSettingsApplier: SettingsApplier<ShellScriptConfigurationSettings>,
            private val springBootConfigurationApplier: SettingsApplier<SpringBootSettings>
) : SettingsApplier<ConfigurationSettings> {

    override fun apply(settings: ConfigurationSettings) {
        when (settings) {
            is ApplicationConfigurationSettings -> applicationConfigurationSettingsApplier.apply(settings)
            is DockerComposeConfigurationSettings -> dockerComposeConfigurationSettingsApplier.apply(settings)
            is DockerImageConfigurationSettings -> dockerImageConfigurationSettingsApplier.apply(settings)
            is RemoteSettings -> remoteConfigurationApplier.apply(settings)
            is ShellScriptConfigurationSettings -> shellScriptConfigurationSettingsApplier.apply(settings)
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
        settings.shareThroughVcs?.let { runnerAndConfigurationSettings.isShared = it }
        runManager.addConfiguration(runnerAndConfigurationSettings)
    }
}
