package com.github.alexandrecarlton.idea.settings.layout.configurations.remote

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings

data class RemoteSettings (
    @JsonProperty("Name")
    override val name: String,

    @JsonProperty("Share through VCS")
    override val shareThroughVcs: Boolean? = null,

    @JsonProperty("Before launch")
    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    @JsonProperty("Configuration")
    val configuration: RemoteConfigurationSettings? = null
) : ConfigurationSettings
