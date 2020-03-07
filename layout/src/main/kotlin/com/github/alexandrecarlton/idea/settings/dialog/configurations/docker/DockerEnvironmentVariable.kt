package com.github.alexandrecarlton.idea.settings.dialog.configurations.docker

import com.fasterxml.jackson.annotation.JsonProperty

data class DockerEnvironmentVariable(

    @JsonProperty("Name")
    val name: String,

    @JsonProperty("Value")
    val value: String? = null
)
