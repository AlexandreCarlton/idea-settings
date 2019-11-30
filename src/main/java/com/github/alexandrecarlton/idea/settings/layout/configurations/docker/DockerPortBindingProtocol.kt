package com.github.alexandrecarlton.idea.settings.layout.configurations.docker

import com.fasterxml.jackson.annotation.JsonProperty

enum class DockerPortBindingProtocol {

    @JsonProperty("tcp")
    TCP,

    @JsonProperty("udp")
    UDP
}
