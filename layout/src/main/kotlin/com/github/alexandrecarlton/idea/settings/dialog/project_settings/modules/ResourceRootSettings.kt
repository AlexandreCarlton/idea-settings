package com.github.alexandrecarlton.idea.settings.dialog.project_settings.modules

import com.fasterxml.jackson.annotation.JsonProperty


data class ResourceRootSettings(

    @JsonProperty("Root")
    val root: String,

    @JsonProperty("Properties")
    val properties: ResourceRootPropertiesSettings? = null
)
