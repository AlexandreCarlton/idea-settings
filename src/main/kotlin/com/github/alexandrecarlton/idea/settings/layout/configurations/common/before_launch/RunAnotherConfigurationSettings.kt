package com.github.alexandrecarlton.idea.settings.layout.configurations.common.before_launch

import com.fasterxml.jackson.annotation.JsonProperty

data class RunAnotherConfigurationSettings(

    @JsonProperty("Name")
    val name: String,

    @JsonProperty("Type")
    val type: RunConfigurationType? = null
) : BeforeLaunchConfigurationSettings
