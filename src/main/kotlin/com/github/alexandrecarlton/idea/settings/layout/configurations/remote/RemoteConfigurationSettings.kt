package com.github.alexandrecarlton.idea.settings.layout.configurations.remote

import com.fasterxml.jackson.annotation.JsonProperty

data class RemoteConfigurationSettings(

    @JsonProperty("Host")
    val host: String? = null,

    @JsonProperty("Port")
    val port: Int? = null
)
