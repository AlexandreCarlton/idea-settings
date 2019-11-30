package com.github.alexandrecarlton.idea.settings.layout.configurations.docker

data class DockerEnvironmentVariable(
    // TODO: Verify if this can indeed be null.
    val name: String? = null,

    val value: String? = null
)
