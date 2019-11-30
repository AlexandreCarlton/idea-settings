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
        settings.imageId().ifPresent { dockerDeploymentConfiguration.imageTag = it }
        settings.containerName().ifPresent { dockerDeploymentConfiguration.containerName = it }
        settings.publishExposedPortsToTheHostInterfaces()
            .map { this.toPublishAllPorts(it) }
            .ifPresent { dockerDeploymentConfiguration.isPublishAllPorts = it }
        settings.executable().flatMap { it.entrypoint() }
            .ifPresent { dockerDeploymentConfiguration.entrypoint = it }
        settings.executable().flatMap { it.command() }
            .ifPresent { dockerDeploymentConfiguration.command = it }
        settings.bindPorts().ifPresent { bindings ->
            dockerDeploymentConfiguration.portBindings = bindings.map { this.toDockerPortBindingImpl(it) }
        }
        settings.environmentVariables().ifPresent { variables ->
            dockerDeploymentConfiguration.envVars = variables.map { this.toDockerEnvVarImpl(it) }
        }
        settings.runOptions().ifPresent { dockerDeploymentConfiguration.runCliOptions = it }

        val runnerAndConfigurationSettings = dockerRunConfigurationCreator.createConfiguration(
            DockerImageDeploymentSourceType.getInstance().singletonSource,
            dockerDeploymentConfiguration,
            null)
        runnerAndConfigurationSettings.name = settings.name()
        runManager.addConfiguration(runnerAndConfigurationSettings)
    }

    private fun toPublishAllPorts(publishToHostInterface: DockerPublishToHostInterface) =
        when (publishToHostInterface) {
            ALL -> true
            SPECIFY -> false
        }

    private fun toDockerPortBindingImpl(dockerPortBinding: DockerPortBinding): DockerPortBindingImpl {
        val dockerPortBindingImpl = DockerPortBindingImpl()
        dockerPortBinding.hostPort().ifPresent { dockerPortBindingImpl.hostPort = it }
        dockerPortBinding.containerPort().ifPresent { dockerPortBindingImpl.containerPort = it }
        dockerPortBinding.hostIp().ifPresent { dockerPortBindingImpl.hostIp = it }
        dockerPortBinding.protocol().map { this.toProtocolString(it) }.ifPresent { dockerPortBindingImpl.protocol = it }
        return dockerPortBindingImpl
    }

    private fun toDockerEnvVarImpl(dockerEnvironmentVariable: DockerEnvironmentVariable): DockerEnvVarImpl {
        val dockerEnvVarImpl = DockerEnvVarImpl()
        dockerEnvironmentVariable.name().ifPresent { dockerEnvVarImpl.name = it }
        dockerEnvironmentVariable.value().ifPresent { dockerEnvVarImpl.value = it }
        return dockerEnvVarImpl
    }

    private fun toProtocolString(protocol: DockerPortBindingProtocol) =
        when (protocol) {
            DockerPortBindingProtocol.TCP -> "tcp"
            DockerPortBindingProtocol.UDP -> "udp"
        }
}
