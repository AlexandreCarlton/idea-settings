package com.github.alexandrecarlton.idea.settings.dialog.configurations.docker

import com.github.alexandrecarlton.idea.settings.dialog.SettingsApplier
import com.github.alexandrecarlton.idea.settings.dialog.configurations.DockerImageConfigurationSettings
import com.github.alexandrecarlton.idea.settings.dialog.configurations.common.environment.EnvironmentVariable
import com.github.alexandrecarlton.idea.settings.dialog.configurations.docker.DockerPublishToHostInterface.ALL
import com.github.alexandrecarlton.idea.settings.dialog.configurations.docker.DockerPublishToHostInterface.SPECIFY
import com.intellij.docker.DockerDeploymentConfiguration
import com.intellij.docker.DockerRunConfigurationCreator
import com.intellij.docker.agent.settings.DockerEnvVarImpl
import com.intellij.docker.agent.settings.DockerPortBindingImpl
import com.intellij.docker.deploymentSource.DockerImageDeploymentSourceType
import com.intellij.execution.RunManager
import com.intellij.remoteServer.impl.configuration.deployment.DeployToServerRunConfiguration
import javax.inject.Inject

class DockerImageConfigurationSettingsApplier @Inject
constructor(
    private val dockerRunConfigurationCreator: DockerRunConfigurationCreator,
    private val runManager: RunManager
) : SettingsApplier<DockerImageConfigurationSettings> {

    override fun apply(settings: DockerImageConfigurationSettings) {

        val dockerDeploymentConfiguration = DockerDeploymentConfiguration()
        settings.imageId?.let { dockerDeploymentConfiguration.setTheOnlyImageTag(it) }
        settings.containerName?.let { dockerDeploymentConfiguration.containerName = it }
        settings.publishExposedPortsToTheHostInterfaces?.let { dockerDeploymentConfiguration.isPublishAllPorts = toPublishAllPorts(it) }
        settings.executable?.entrypoint?.let { dockerDeploymentConfiguration.entrypoint = it }
        settings.executable?.command?.let { dockerDeploymentConfiguration.command = it }
        settings.bindPorts?.let { dockerDeploymentConfiguration.portBindings = it.map(::toDockerPortBindingImpl) }
        settings.environmentVariables?.let { dockerDeploymentConfiguration.envVars = it.map(::toDockerEnvVarImpl) }
        settings.runOptions?.let { dockerDeploymentConfiguration.runCliOptions = it }

        val runnerAndConfigurationSettings = dockerRunConfigurationCreator.createConfiguration(
            DockerImageDeploymentSourceType.getInstance().singletonSource,
            dockerDeploymentConfiguration,
            null)
        settings.server?.let {
            val deployToServerRunConfiguration = runnerAndConfigurationSettings.configuration as DeployToServerRunConfiguration<*, *>
            deployToServerRunConfiguration.serverName = it
        }
        runnerAndConfigurationSettings.name = settings.name
        runManager.addConfiguration(runnerAndConfigurationSettings)
    }

    private fun toPublishAllPorts(publishToHostInterface: DockerPublishToHostInterface) =
        when (publishToHostInterface) {
            ALL -> true
            SPECIFY -> false
        }

    private fun toDockerPortBindingImpl(dockerPortBinding: DockerPortBinding): DockerPortBindingImpl {
        val dockerPortBindingImpl = DockerPortBindingImpl()
        dockerPortBinding.hostPort?.let { dockerPortBindingImpl.hostPort = it }
        dockerPortBinding.containerPort?.let { dockerPortBindingImpl.containerPort = it }
        dockerPortBinding.hostIp?.let { dockerPortBindingImpl.hostIp = it }
        dockerPortBinding.protocol?.let { dockerPortBindingImpl.protocol = toProtocolString(it) }
        return dockerPortBindingImpl
    }

    private fun toDockerEnvVarImpl(environmentVariable: EnvironmentVariable): DockerEnvVarImpl =
        DockerEnvVarImpl().apply {
            name = environmentVariable.name
            value = environmentVariable.value
        }

    private fun toProtocolString(protocol: DockerPortBindingProtocol) =
        when (protocol) {
            DockerPortBindingProtocol.TCP -> "tcp"
            DockerPortBindingProtocol.UDP -> "udp"
        }
}
