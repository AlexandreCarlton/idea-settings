package com.github.alexandrecarlton.idea.settings.layout.configurations.docker

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings
import java.nio.file.Path

data class DockerComposeConfigurationSettings(

    @JsonProperty("Name")
    override val name: String,

    @JsonProperty("Share through VCS")
    override val shareThroughVcs: Boolean? = null,

    @JsonProperty("Before launch")
    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Compose file(s)")
    val composeFiles: List<Path>? = null,

    @JsonProperty("Service(s)")
    val services: List<String>? = null,

    @JsonProperty("Environment variables")
    val environmentVariables: List<DockerEnvironmentVariable>? = null,

    @JsonProperty("Options")
    val options: DockerComposeConfigurationOptionsSettings? = null
) : ConfigurationSettings
