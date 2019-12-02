package com.github.alexandrecarlton.idea.settings.layout.configurations.application

import com.github.alexandrecarlton.idea.settings.layout.configurations.ConfigurationSettings
import com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch.BeforeLaunchConfigurationSettings

data class ApplicationConfigurationSettings(

    override val name: String,

    override val shareThroughVcs: Boolean? = null,

    override val beforeLaunch: List<BeforeLaunchConfigurationSettings>? = null,

    val configuration: ApplicationConfigurationConfigurationSettings

) : ConfigurationSettings
