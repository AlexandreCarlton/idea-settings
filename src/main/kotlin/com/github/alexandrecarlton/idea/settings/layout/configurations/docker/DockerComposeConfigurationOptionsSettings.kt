package com.github.alexandrecarlton.idea.settings.layout.configurations.docker

import com.fasterxml.jackson.annotation.JsonProperty

data class DockerComposeConfigurationOptionsSettings(
    @JsonProperty("--build, force build images")
    val buildForceBuildImages: Boolean? = null
)
