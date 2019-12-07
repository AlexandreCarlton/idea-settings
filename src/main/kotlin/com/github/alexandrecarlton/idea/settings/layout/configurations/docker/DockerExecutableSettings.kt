package com.github.alexandrecarlton.idea.settings.layout.configurations.docker

import com.fasterxml.jackson.annotation.JsonProperty

data class DockerExecutableSettings(

    @JsonProperty("Entrypoint")
    val entrypoint: String,

    @JsonProperty("Command")
    val command: String
)
