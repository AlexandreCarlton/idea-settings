package com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch

data class RunAnotherConfigurationSettings(
    val name: String,
    val type: RunConfigurationType? = null
) : BeforeLaunchConfigurationSettings
