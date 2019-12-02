package com.github.alexandrecarlton.idea.settings.applier.impl.configurations.docker

import com.github.alexandrecarlton.idea.settings.applier.api.SettingsApplier
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerEnvironmentVariable
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerImageConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPortBinding
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPortBindingProtocol
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPublishToHostInterface
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPublishToHostInterface.ALL
import com.github.alexandrecarlton.idea.settings.layout.configurations.docker.DockerPublishToHostInterface.SPECIFY
import com.intellij.docker.DockerDeploymentConfiguration
import com.intellij.docker.DockerRunConfigurationCreator
import com.intellij.docker.agent.settings.DockerEnvVarImpl
import com.intellij.docker.agent.settings.DockerPortBindingImpl
import com.intellij.docker.deploymentSource.DockerImageDeploymentSourceType
import com.intellij.execution.RunManager
import javax.inject.Inject

class DockerImageConfigurationSettingsApplier @Inject
constructor(
    private val dockerRunConfigurationCreator: DockerRunConfigurationCreator,
    private val runManager: RunManager
) : SettingsApplier<DockerImageConfigurationSettings> {

    override fun apply(settings: DockerImageConfigurationSettings) {

        val dockerDeploymentConfiguration = DockerDeploymentConfiguration()
        settings.imageId?.let { dockerDeploymentConfiguration.imageTag = it }
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

    private fun toDockerEnvVarImpl(dockerEnvironmentVariable: DockerEnvironmentVariable): DockerEnvVarImpl {
        val dockerEnvVarImpl = DockerEnvVarImpl()
        dockerEnvironmentVariable.name?.let { dockerEnvVarImpl.name = it }
        dockerEnvironmentVariable.value?.let { dockerEnvVarImpl.value = it }
        return dockerEnvVarImpl
    }

    private fun toProtocolString(protocol: DockerPortBindingProtocol) =
        when (protocol) {
            DockerPortBindingProtocol.TCP -> "tcp"
            DockerPortBindingProtocol.UDP -> "udp"
        }
}
