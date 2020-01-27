package com.github.alexandrecarlton.idea.settings.layout.project_settings.modules

import com.fasterxml.jackson.annotation.JsonProperty

data class SourceRootSettings(

    @JsonProperty("Root")
    val root: String,

    @JsonProperty("Properties")
    val properties: SourceRootPropertiesSettings? = null
)
