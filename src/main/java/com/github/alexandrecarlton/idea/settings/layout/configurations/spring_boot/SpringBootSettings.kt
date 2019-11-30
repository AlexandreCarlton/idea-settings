package com.github.alexandrecarlton.idea.settings.layout.configurations.spring_boot

import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings

data class SpringBootSettings (
    override val name: String,

    override val shareThroughVcs: Boolean? = null,

    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    val configuration: SpringBootConfigurationSettings
) : ConfigurationSettings
