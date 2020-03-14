package com.github.alexandrecarlton.idea.settings.dialog.configurations.common.environment

import com.fasterxml.jackson.annotation.JsonProperty

// TODO: We should have EnvironmentVariableSettings - has the option to pass in the parent environment.
data class EnvironmentVariable(

    @JsonProperty("Name")
    val name: String,

    @JsonProperty("Value")
    val value: String? = null
)
