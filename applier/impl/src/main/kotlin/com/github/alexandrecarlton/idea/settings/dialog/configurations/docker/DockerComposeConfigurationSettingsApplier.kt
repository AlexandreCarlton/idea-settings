package com.github.alexandrecarlton.idea.settings.dialog.configurations.docker

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.configurations.DockerComposeConfigurationSettings
import com.intellij.docker.DockerDeploymentConfiguration
import com.intellij.docker.DockerRunConfigurationCreator
import com.intellij.docker.agent.settings.DockerEnvVarImpl
import com.intellij.docker.deploymentSource.DockerComposeDeploymentSourceType
import com.intellij.execution.RunManager
import com.intellij.remoteServer.impl.configuration.deployment.DeployToServerRunConfiguration
import javax.inject.Inject

class DockerComposeConfigurationSettingsApplier @Inject
constructor(private val dockerRunConfigurationCreator: DockerRunConfigurationCreator,
            private val runManager: RunManager) : SettingsApplier<DockerComposeConfigurationSettings> {

    override fun apply(settings: DockerComposeConfigurationSettings) {
        val dockerComposeDeploymentSourceType = DockerComposeDeploymentSourceType.getInstance()
        val dockerDeploymentConfiguration = DockerDeploymentConfiguration()

        settings.services?.let { dockerDeploymentConfiguration.services = it }

        settings.composeFiles
            ?.let { composeFiles -> composeFiles.map { it.absolutePath } }
            ?.let { composeFiles -> if (composeFiles.isNotEmpty()) composeFiles else null }
            ?.let { composeFiles ->
                dockerDeploymentConfiguration.sourceFilePath = composeFiles[0]
                dockerDeploymentConfiguration.secondarySourceFiles = composeFiles.subList(1, composeFiles.size)
            }

        settings.environmentVariables?.let { variables -> dockerDeploymentConfiguration.envVars = variables.map { DockerEnvVarImpl(it.name, it.value) } }

        settings.options?.buildForceBuildImages?.let { dockerComposeDeploymentSourceType.applyForceBuild(dockerDeploymentConfiguration, it) }

        val runnerAndConfigurationSettings = dockerRunConfigurationCreator.createConfiguration(
            dockerComposeDeploymentSourceType.singletonSource,
            dockerDeploymentConfiguration,
            null)
        settings.server?.let {
            val deployToServerRunConfiguration = runnerAndConfigurationSettings.configuration as DeployToServerRunConfiguration<*, *>
            deployToServerRunConfiguration.serverName = it
        }
        runnerAndConfigurationSettings.name = settings.name
        runManager.addConfiguration(runnerAndConfigurationSettings)
    }
}
