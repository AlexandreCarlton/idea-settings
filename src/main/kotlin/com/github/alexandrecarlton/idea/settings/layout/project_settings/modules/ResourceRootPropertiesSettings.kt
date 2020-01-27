package com.github.alexandrecarlton.idea.settings.layout.project_settings.modules

import com.fasterxml.jackson.annotation.JsonProperty


data class ResourceRootPropertiesSettings(
    @JsonProperty("Package prefix")
    val packagePrefix: String? = null,

    @JsonProperty("For generated resources")
    val forGeneratedResources: Boolean? = null
)
