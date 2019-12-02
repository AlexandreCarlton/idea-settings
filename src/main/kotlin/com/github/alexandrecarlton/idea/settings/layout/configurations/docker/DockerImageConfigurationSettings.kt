package com.github.alexandrecarlton.idea.settings.layout.configurations.docker

import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings

data class DockerImageConfigurationSettings(

    override val name: String,

    override val shareThroughVcs: Boolean? = null,

    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    val imageId: String? = null,

    val containerName: String? = null,

    val publishExposedPortsToTheHostInterfaces: DockerPublishToHostInterface? = null,

    val executable: DockerExecutableSettings? = null,

    val bindPorts: List<DockerPortBinding>? = null,

    // TODO: bindMounts

    val environmentVariables: List<DockerEnvironmentVariable>? = null,

    val runOptions: String? = null

) : ConfigurationSettings
