package com.github.alexandrecarlton.idea.settings.layout.configurations.docker

import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings
import java.nio.file.Path

data class DockerComposeConfigurationSettings(

    override val name: String,

    override val shareThroughVcs: Boolean? = null,

    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    val composeFiles: List<Path>? = null,

    val services: List<String>? = null,

    val environmentVariables: List<DockerEnvironmentVariable>? = null,

    val options: DockerComposeConfigurationOptionsSettings? = null
) : ConfigurationSettings
