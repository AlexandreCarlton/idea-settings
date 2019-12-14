package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.remote

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.configurations.RemoteSettings
import com.intellij.execution.RunManager
import com.intellij.execution.remote.RemoteConfiguration
import com.intellij.execution.remote.RemoteConfigurationType
import com.intellij.openapi.project.Project
import javax.inject.Inject

class RemoteSettingsApplier @Inject
constructor(private val runManager: RunManager, private val project: Project) : SettingsApplier<RemoteSettings> {

    override fun apply(settings: RemoteSettings) {
        val remoteConfiguration = RemoteConfiguration(project, RemoteConfigurationType())
        remoteConfiguration.name = settings.name
        settings.configuration?.host?.let { remoteConfiguration.HOST = it }
        settings.configuration?.port?.let { remoteConfiguration.PORT = it.toString() }
        val runnerAndConfigurationSettings = runManager.createConfiguration(remoteConfiguration, RemoteConfigurationType())
        runManager.addConfiguration(runnerAndConfigurationSettings)
    }
}
