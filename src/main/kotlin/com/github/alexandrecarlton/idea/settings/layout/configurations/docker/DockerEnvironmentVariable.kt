package com.github.alexandrecarlton.idea.settings.layout.configurations.docker

import com.fasterxml.jackson.annotation.JsonProperty

data class DockerEnvironmentVariable(

    @JsonProperty("Name")
    val name: String,

    @JsonProperty("Value")
    val value: String? = null
)
