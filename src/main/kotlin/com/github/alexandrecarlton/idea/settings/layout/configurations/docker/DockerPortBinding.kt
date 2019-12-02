package com.github.alexandrecarlton.idea.settings.layout.configurations.docker

data class DockerPortBinding(

    val hostPort: Int? = null,

    val containerPort: Int? = null,

    val protocol: DockerPortBindingProtocol? = null,

    val hostIp: String? = null
)
