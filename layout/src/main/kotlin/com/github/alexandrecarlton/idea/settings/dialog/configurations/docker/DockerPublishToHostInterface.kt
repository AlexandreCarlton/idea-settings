package com.github.alexandrecarlton.idea.settings.dialog.configurations.docker

import com.fasterxml.jackson.annotation.JsonProperty

enum class DockerPublishToHostInterface {
    @JsonProperty("All")
    ALL,

    @JsonProperty("Specify")
    SPECIFY
}
