package com.github.alexandrecarlton.idea.settings.dialog.configurations.docker

import com.fasterxml.jackson.annotation.JsonProperty

data class DockerPortBinding(

    @JsonProperty("Host port")
    val hostPort: Int? = null,

    @JsonProperty("Container port")
    val containerPort: Int? = null,

    @JsonProperty("Protocol")
    val protocol: DockerPortBindingProtocol? = null,

    @JsonProperty("Host IP")
    val hostIp: String? = null
)
