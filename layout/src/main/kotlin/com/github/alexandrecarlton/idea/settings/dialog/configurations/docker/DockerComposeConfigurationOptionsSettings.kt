package com.github.alexandrecarlton.idea.settings.dialog.configurations.docker

import com.fasterxml.jackson.annotation.JsonProperty

data class DockerComposeConfigurationOptionsSettings(
    @JsonProperty("--build, force build images")
    val buildForceBuildImages: Boolean? = null
)
