package com.github.alexandrecarlton.idea.settings.layout.build_execution_deployment

import com.fasterxml.jackson.annotation.JsonProperty

data class RequiredPlugin(

    @JsonProperty("Plugin")
    val plugin: String,

    @JsonProperty("Minimum version")
    val minimumVersion: String? = null,

    @JsonProperty("Maximum version")
    val maximumVersion: String? = null
)
