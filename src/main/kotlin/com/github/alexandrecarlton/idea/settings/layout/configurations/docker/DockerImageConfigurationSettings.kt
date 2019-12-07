package com.github.alexandrecarlton.idea.settings.layout.configurations.docker

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings

data class DockerImageConfigurationSettings(

    @JsonProperty("Name")
    override val name: String,

    @JsonProperty("Share through VCS")
    override val shareThroughVcs: Boolean? = null,

    @JsonProperty("Before launch")
    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Image ID")
    val imageId: String? = null,

    @JsonProperty("Container name")
    val containerName: String? = null,

    @JsonProperty("Publish exposed ports to the host interfaces")
    val publishExposedPortsToTheHostInterfaces: DockerPublishToHostInterface? = null,

    @JsonProperty("Executable")
    val executable: DockerExecutableSettings? = null,

    @JsonProperty("Bind ports")
    val bindPorts: List<DockerPortBinding>? = null,

    // TODO: bindMounts

    @JsonProperty("Environment variables")
    val environmentVariables: List<DockerEnvironmentVariable>? = null,

    @JsonProperty("Run options")
    val runOptions: String? = null

) : ConfigurationSettings
