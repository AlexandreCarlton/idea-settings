package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.docker

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerComposeConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerEnvironmentVariable
import com.intellij.docker.DockerDeploymentConfiguration
import com.intellij.docker.DockerRunConfigurationCreator
import com.intellij.docker.agent.settings.DockerEnvVarImpl
import com.intellij.docker.deploymentSource.DockerComposeDeploymentSourceType
import com.intellij.execution.RunManager
import java.util.Optional
import javax.inject.Inject

class DockerComposeConfigurationSettingsApplier @Inject
constructor(private val dockerRunConfigurationCreator: DockerRunConfigurationCreator,
            private val runManager: RunManager) : SettingsApplier<DockerComposeConfigurationSettings> {

    override fun apply(settings: DockerComposeConfigurationSettings) {
        val dockerComposeDeploymentSourceType = DockerComposeDeploymentSourceType.getInstance()
        val dockerDeploymentConfiguration = DockerDeploymentConfiguration()

        settings.services?.let { dockerDeploymentConfiguration.services = it }

        settings.composeFiles
            ?.let { composeFiles ->
                composeFiles
                    .map { it.toAbsolutePath() }
                    .map { it.toString() }
            }
            ?.let { composeFiles -> if (composeFiles.isNotEmpty()) composeFiles else null }
            ?.let { composeFiles ->
                dockerDeploymentConfiguration.sourceFilePath = composeFiles[0]
                dockerDeploymentConfiguration.secondarySourceFiles = composeFiles.subList(1, composeFiles.size)
            }

        settings.environmentVariables?.let { variables -> dockerDeploymentConfiguration.envVars = variables.map { toDockerEnvVarImpl(it) } }

        settings.options?.buildForceBuildImages?.let { dockerComposeDeploymentSourceType.applyForceBuild(dockerDeploymentConfiguration, it) }

        val runnerAndConfigurationSettings = dockerRunConfigurationCreator.createConfiguration(
            dockerComposeDeploymentSourceType.singletonSource,
            dockerDeploymentConfiguration,
            null)
        runnerAndConfigurationSettings.name = settings.name
        runManager.addConfiguration(runnerAndConfigurationSettings)
    }

    private fun toDockerEnvVarImpl(dockerEnvironmentVariable: DockerEnvironmentVariable): DockerEnvVarImpl {
        val dockerEnvVarImpl = DockerEnvVarImpl()
        dockerEnvironmentVariable.name.let { dockerEnvVarImpl.name = it }
        dockerEnvironmentVariable.value?.let { dockerEnvVarImpl.value = it }
        return dockerEnvVarImpl
    }
}
